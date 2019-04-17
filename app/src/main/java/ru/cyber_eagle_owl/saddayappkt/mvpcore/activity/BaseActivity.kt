package ru.cyber_eagle_owl.saddayappkt.mvpcore.activity

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ru.cyber_eagle_owl.saddayappkt.mvpcore.activity.interfaces.MvpActivityView

abstract class BaseActivity : AppCompatActivity(), MvpActivityView {

    private var currentToast: Toast? = null

    override fun showToastMsg(toastMsg: String) {
        if (currentToast != null) { // null использвать плохо
            currentToast!!.cancel()
        }
        currentToast = Toast.makeText(this, toastMsg, Toast.LENGTH_LONG)
        currentToast!!.show()
    }
}
