package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.viper.PlaceMainViperContract
import timber.log.Timber
import javax.inject.Inject

class PlaceActivity : BaseActivity() {

    private var currentToast: Toast? = null

    @Inject
    lateinit var mainView: PlaceMainViperContract.MainView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("onCreate")

        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_place, null)
        setContentView(rootView)

        prepareScreen()
        val dens: Float = this.resources.displayMetrics.density
        prepareToolbar(resources.configuration.orientation, dens)

        mainView.apply {
            setRootView(rootView)
            onFinishInflate()
        }
    }

    override fun onResume() {
        super.onResume()
        initRouterToolbox()
        Timber.d("onResume()")
        Timber.d("routerToolbox = $routerToolbox")
        mainView.onResume(routerToolbox)
    }

    private fun prepareToolbar(orientation: Int, dens: Float) {
        Timber.d("prepareToolbar()")

        setSupportActionBar(toolbar)
        toolbar.setBackgroundResource(R.color.colorShadeForFrontEndElements)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitle(R.string.main_menu_item_title_place)

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).marginStart = (48 * dens).toInt()
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (48 * dens).toInt()
        }
    }

    fun showToast(toastText: String) {

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
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

    companion object {
        fun startFrom(context: Context) {
            Intent(context, PlaceActivity::class.java)
                .apply {
                    //to set some flags here, like it:
                    //flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                .also { context.startActivity(it) }
        }
    }
}