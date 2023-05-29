package com.bitcodetech.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitcodetech.mvvm.auth.activities.LoginActivity
import com.bitcodetech.mvvm.products.ProductsActivity
import com.bitcodetech.mvvm.util.prefs.Preferences

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isUserLogged()) {
            startProductsActivity()
        }
        else {
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun startProductsActivity() {
        startActivity(
            Intent(this, ProductsActivity::class.java)
        )
    }

    private fun isUserLogged() : Boolean {
        return Preferences.getToken(this) != null
    }

}