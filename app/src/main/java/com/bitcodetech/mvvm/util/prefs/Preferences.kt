package com.bitcodetech.mvvm.util.prefs

import android.app.Activity
import android.content.Context

object Preferences {

    private const val TOKEN_PREF_NAME = "token_pref"
    private const val KEY_TOKEN = "token"

    fun writeToken(
        context: Context,
        token: String
    ) : Boolean {

        context.getSharedPreferences(
            TOKEN_PREF_NAME,
            Activity.MODE_PRIVATE
        )
            .edit()
            .putString(KEY_TOKEN, "bearer $token")
            .commit()

        return true
    }

    fun getToken(
        context: Context
    ) : String? {
        val tokenPrefs = context.getSharedPreferences(
            TOKEN_PREF_NAME,
            Activity.MODE_PRIVATE
        )

        return if(tokenPrefs.contains(KEY_TOKEN)) {
            tokenPrefs.getString(KEY_TOKEN, null)
        }
        else {
            null
        }
    }


    fun removeToken(
        context: Context
    ) : Boolean {
        val tokenPrefs = context.getSharedPreferences(
            TOKEN_PREF_NAME,
            Activity.MODE_PRIVATE
        )

        if(tokenPrefs.contains(KEY_TOKEN)) {
            tokenPrefs.edit().remove(KEY_TOKEN).commit()
            return true
        }

        return false
    }

}