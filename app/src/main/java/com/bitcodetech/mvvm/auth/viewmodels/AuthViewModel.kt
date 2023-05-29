package com.bitcodetech.mvvm.auth.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.mvvm.auth.models.Credentials
import com.bitcodetech.mvvm.auth.models.LoginResponse
import com.bitcodetech.mvvm.auth.repo.AuthRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel(
    private val authRepo: AuthRepo
) : ViewModel() {

    val loginResponseLiveData = MutableLiveData<LoginResponse>()


    fun authUser(
        username : String,
        password : String
    ) {

        CoroutineScope(Dispatchers.IO).launch {
            val response = authRepo.authUser(
                Credentials(
                    username, password
                )
            )

            withContext(Dispatchers.Main) {
                loginResponseLiveData.postValue(response)
            }
        }


    }

}