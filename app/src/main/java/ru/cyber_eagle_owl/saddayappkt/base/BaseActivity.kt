package ru.cyber_eagle_owl.saddayappkt.base

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import dagger.android.support.DaggerAppCompatActivity
import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox
import timber.log.Timber

abstract class BaseActivity : DaggerAppCompatActivity() {

    private lateinit var routerToolbox: RouterToolbox

    fun getRouterToolbox(): RouterToolbox {
        if (!::routerToolbox.isInitialized) routerToolbox = RouterToolbox(this)
        return routerToolbox
    }

    fun prepareScreen(){
        Timber.d("prepareScreen()")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }
}