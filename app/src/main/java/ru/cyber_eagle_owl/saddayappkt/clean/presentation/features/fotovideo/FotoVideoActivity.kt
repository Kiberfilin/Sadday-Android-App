package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.fotovideo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.placeholder_layout_for_many_activityes.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity

class FotoVideoActivity  : BaseActivity(), FotoVideoMvp.View {

    private var currentToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.placeholder_layout_for_many_activityes)

        textView.text = localClassName
    }

    override fun showToast(toastText: String) {

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
    }


    companion object {
        fun startFrom(context: Context) {
            Intent(context, FotoVideoActivity::class.java)
            .apply {
                //to set some flags here, like it:
                //flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
                .also { context.startActivity(it) }
        }
    }
}