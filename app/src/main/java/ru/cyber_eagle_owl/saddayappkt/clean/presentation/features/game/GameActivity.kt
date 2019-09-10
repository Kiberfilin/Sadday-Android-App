package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.placeholder_layout_for_many_activityes.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class GameActivity : BaseActivity() {

    private var currentToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        Timber.d("onCreate")

        setContentView(R.layout.activity_game)

        prepareScreen()

        val dens: Float = this.resources.displayMetrics.density

        prepareToolbar(resources.configuration.orientation, dens)

        prepareTabs(resources.configuration.orientation, dens)
    }

    private fun prepareTabs(orientation: Int, dens: Float) {
        val fragmentAdapter = GamePagerAdapter(supportFragmentManager)
        gameActivityPager?.adapter = fragmentAdapter
        gameActivityTabs.setupWithViewPager(gameActivityPager)

        gameActivityPager.layoutParams.also {pagerParams ->
            pagerParams as ViewGroup.MarginLayoutParams
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                gameActivityTabs.layoutParams.also {tabsParams ->
                    tabsParams as ViewGroup.MarginLayoutParams
                    tabsParams.marginStart = (48 * dens).toInt()
                    tabsParams.marginEnd = (48 * dens).toInt()
                }

                pagerParams.marginStart = (48 * dens).toInt()
                pagerParams.marginEnd = (48 * dens).toInt()
            } else {
                pagerParams.bottomMargin = (48 * dens).toInt()
                pagerParams.marginStart = (8 * dens).toInt()
                pagerParams.marginEnd = (8 * dens).toInt()
            }
        }

    }

    private fun prepareToolbar(orientation: Int, dens: Float) {
        Timber.d("prepareToolbar()")

        setSupportActionBar(toolbar)
        toolbar.setBackgroundResource(R.color.colorShadeForFrontEndElements)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitle(R.string.main_menu_item_title_sadday_game)

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).marginStart = (48 * dens).toInt()
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (48 * dens).toInt()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Timber.d("onOptionsItemSelected")

        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun showToast(toastText: String) {

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }

    companion object {
        fun startFrom(context: Context) {
            Intent(context, GameActivity::class.java)
                .apply {
                    //to set some flags here, like it:
                    //flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                .also { context.startActivity(it) }
        }
    }
}