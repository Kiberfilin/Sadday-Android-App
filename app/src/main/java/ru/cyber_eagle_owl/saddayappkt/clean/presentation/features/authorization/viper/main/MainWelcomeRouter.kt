package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.main

import android.app.Activity
import android.content.Intent
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.authorization.viper.WelcomeViperContract
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu.MainMenuActivity
import ru.cyber_eagle_owl.saddayappkt.clean.vipercore.BaseRouter
import timber.log.Timber
import javax.inject.Inject

class MainWelcomeRouter @Inject constructor() : BaseRouter(), WelcomeViperContract.WelcomeRouter {

    override fun routeToMainMenuActivity() {
        Timber.d("routeToMainMenuActivity()")
        Intent(toolbox.activityContext(), MainMenuActivity::class.java)
            .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP }
            .also { toolbox.activityContext().startActivity(it) }
        (toolbox.activityContext() as Activity).finish()
    }
}