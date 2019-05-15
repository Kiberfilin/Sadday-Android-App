package ru.cyber_eagle_owl.saddayappkt.features.authorization

import ru.cyber_eagle_owl.saddayappkt.utils.SharedPreferencesHelper
import javax.inject.Inject

class WelcomeRepo @Inject constructor(var sharedPreferencesHelper: SharedPreferencesHelper) : WelcomeMvp.Model {

    override fun saveStringDataToSharedPreferences(key: String, data: String) {
        sharedPreferencesHelper.saveStringData(key, data)
    }

    override fun getStringDataToSharedPreferences(key: String): String {
        return sharedPreferencesHelper.getStringData(key)
    }

}