package ru.cyber_eagle_owl.saddayappkt.mvpcore.fragment

import android.support.v4.app.Fragment
import android.widget.Toast
import ru.cyber_eagle_owl.saddayappkt.mvpcore.fragment.interfaces.MvpFragmentView

abstract class BaseFragment : Fragment(), MvpFragmentView {

    private var currentToast: Toast? = null

    override fun showToastMsg(toastMsg: String) {
        if (currentToast != null) {
            currentToast!!.cancel()
        }
        currentToast = Toast.makeText(activity, toastMsg, Toast.LENGTH_LONG)
        currentToast!!.show()
    }
}