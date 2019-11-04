package ru.cyber_eagle_owl.saddayappkt.utils.wrappers

import android.content.Context
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity

class RouterToolbox(private val activity: BaseActivity){

    fun fragmentManager() = activity.supportFragmentManager
    fun activityContext(): Context = activity
}