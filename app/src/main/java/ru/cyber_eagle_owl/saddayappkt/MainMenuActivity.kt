package ru.cyber_eagle_owl.saddayappkt

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.cyber_eagle_owl.saddayappkt.authorization.mvp.view.WelcomeActivityMvpView

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    companion object {
        fun startFrom(context: WelcomeActivityMvpView) {
            val intent = Intent(context as Context, MainMenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }
    }
}
