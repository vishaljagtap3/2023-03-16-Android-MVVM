package com.bitcodetech.mvvm.auth.repo

import com.bitcodetech.mvvm.auth.models.Credentials
import com.bitcodetech.mvvm.auth.models.LoginResponse
import com.bitcodetech.mvvm.auth.network.AuthService
import com.bitcodetech.mvvm.products.repositories.BaseRepository
import retrofit2.http.Body
import kotlin.time.measureTime

class AuthRepo(
    private val authService: AuthService
) : BaseRepository() {

    suspend fun authUser(
        credentials: Credentials
    ) : LoginResponse {
        return authService.authUser(
            credentials
        )
    }

}