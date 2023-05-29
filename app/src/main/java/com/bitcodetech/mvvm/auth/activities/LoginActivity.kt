package com.bitcodetech.mvvm.auth.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.mvvm.products.ProductsActivity
import com.bitcodetech.mvvm.auth.network.AuthService
import com.bitcodetech.mvvm.auth.viewmodels.AuthViewModel
import com.bitcodetech.mvvm.databinding.LoginActivityBinding
import com.bitcodetech.mvvm.products.provider.ViewModelFactory
import com.bitcodetech.mvvm.auth.repo.AuthRepo
import com.bitcodetech.mvvm.util.prefs.Preferences

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : LoginActivityBinding
    private lateinit var authViewModel : AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModels()
        initObservers()
        initListeners()
    }

    private fun initListeners() {

        binding.btnLogin.setOnClickListener {
            if(!validateInput()) {
                mt("enter valid credentials!")
            }

            authViewModel.authUser(
                binding.edtUsername.text.toString(),
                binding.edtPassword.text.toString()
            )
        }

    }

    private fun validateInput() : Boolean{
        if(binding.edtUsername.text.isEmpty()) {
            return false
        }
        if(binding.edtPassword.text.isEmpty()) {
            return false
        }

        return true
    }

    private fun initViewModels() {
        authViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                AuthRepo(
                    AuthService.getAuthService()
                )
            )
        )[AuthViewModel::class.java]
    }

    private fun initObservers() {
        authViewModel.loginResponseLiveData.observe(
            this
        ) {
            mt("Login Successful")
            Preferences.writeToken(
                this,
                it.data.token
            )
            finish()
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, ProductsActivity::class.java)
        startActivity(intent)
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}