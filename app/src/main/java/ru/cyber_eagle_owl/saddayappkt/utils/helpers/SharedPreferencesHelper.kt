package ru.cyber_eagle_owl.saddayappkt.utils.helpers

import android.content.SharedPreferences

class SharedPreferencesHelper(var sharedPreferences: SharedPreferences) {

    fun saveStringData(key: String, data: String) {
        sharedPreferences.edit()
            .putString(key, data)
            .apply()
    }

    fun getStringData(key: String): String? {
        return sharedPreferences.getString(key, "")
    }
}