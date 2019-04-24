package ru.cyber_eagle_owl.saddayappkt.features.menu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity

class MainMenuActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    companion object {
        fun startFrom(context: Context) {
            Intent(context, MainMenuActivity::class.java)
                .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP }
                .also { context.startActivity(it) }
        }
    }
}
