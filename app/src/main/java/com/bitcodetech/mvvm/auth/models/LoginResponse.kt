package com.bitcodetech.mvvm.auth.models

import com.google.gson.annotations.SerializedName

class LoginResponseData(
    @SerializedName("superAdminId")
    val userId : Int,
    @SerializedName("superAdminToken")
    val token : String
)

class LoginResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    val message: String,
    val data: LoginResponseData
)

/*
{
    "response_code": 0,
    "message": "Login Successful!",
    "data":
    {
        "superAdminId": 1,
        "superAdminName": "testUser",
        "superAdminAddress": "Pune",
        "superAdminToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInVzZXJOYW1lIjoidGVzdFVzZXIiLCJ1c2VyX3R5cGUiOiIxIiwiaWF0IjoxNjg1MzQzOTg3fQ.HL9WY3uluM_YttE0EtBfJVg-acT0aRoMtAInzK0RTSg"
    }
}

*/
