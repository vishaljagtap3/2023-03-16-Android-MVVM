package com.bitcodetech.mvvm.auth.models

import com.google.gson.annotations.SerializedName

data class Credentials(
    @SerializedName("superAdminName")
    val username : String,
    val password : String
)
