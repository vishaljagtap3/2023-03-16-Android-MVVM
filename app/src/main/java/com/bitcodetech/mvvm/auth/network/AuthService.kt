package com.bitcodetech.mvvm.auth.network

import com.bitcodetech.mvvm.auth.models.Credentials
import com.bitcodetech.mvvm.auth.models.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("superadmin/auth")
    suspend fun authUser(
        @Body
        credentials: Credentials
    ) : LoginResponse
    
    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://bitcode.in:3000/apis/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        
        private val authService = retrofit.create(AuthService::class.java)
        
        fun getAuthService(): AuthService = authService
        
    }
}