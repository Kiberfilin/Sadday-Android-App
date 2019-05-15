package ru.cyber_eagle_owl.saddayappkt.features.menu

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_menu.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import javax.inject.Inject

class MainMenuActivity : BaseActivity(), MainMenuMvp.View, MainMenuRecyclerAdapter.OnMenuItemClickListener {

    @Inject
    lateinit var presenter: MainMenuMvp.Presenter

    private val logTag: String = "MainMenuActivity"

    private var currentToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate")

        setContentView(R.layout.activity_main_menu)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        prepareRecyclerView()

        presenter.onViewCreated()
    }

    private fun prepareRecyclerView() {

        val orientation: Int = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            mainMenuRecyclerview.layoutManager = object : LinearLayoutManager(this) {}
        } else {
            mainMenuRecyclerview.layoutManager =
                object : StaggeredGridLayoutManager(2, VERTICAL) {}
        }

        val adapter = MainMenuRecyclerAdapter(this)
        adapter.notifyDataSetChanged()
        mainMenuRecyclerview.adapter = adapter
    }

    override fun showToast(toastText: String) {

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
    }

    override fun onMenuItemClick(stringResIdOfItemTitle: Int) {

        presenter.onMenuItemClicked(stringResIdOfItemTitle)
    }

    companion object {
        fun startFrom(context: Context) {
            Intent(context, MainMenuActivity::class.java)
                .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP }
                .also { context.startActivity(it) }
        }
    }
}
