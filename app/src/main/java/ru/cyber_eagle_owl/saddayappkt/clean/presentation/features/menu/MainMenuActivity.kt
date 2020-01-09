package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_menu.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import ru.cyber_eagle_owl.saddayappkt.constants.AppConstants
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.about.AboutActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.account.AccountActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.fotovideo.FotoVideoActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.GameActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.information.InformationActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news.NewsActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.place.PlaceActivity
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.tickets.TicketsActivity
import timber.log.Timber
import javax.inject.Inject

class MainMenuActivity : BaseActivity(), MainMenuMvp.View, MainMenuRecyclerAdapter.OnMenuItemClickListener {

    @Inject
    lateinit var presenter: MainMenuMvp.Presenter

    private var currentToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")

        setContentView(R.layout.activity_main_menu)

        prepareScreen()
        prepareRecyclerView()

        presenter.onViewCreated()
    }

    private fun prepareRecyclerView() {
        Timber.d("prepareRecyclerView()")

        mainMenuRecyclerview.apply {

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                layoutManager = object : LinearLayoutManager(this@MainMenuActivity) {}
            } else {
                layoutManager = object : StaggeredGridLayoutManager(2, VERTICAL) {}
            }

            adapter = MainMenuRecyclerAdapter(this@MainMenuActivity)
            (adapter as MainMenuRecyclerAdapter).notifyDataSetChanged()
        }
    }

    override fun showToast(toastText: String) {
        Timber.d("showToast(toastText: String)")

        currentToast?.let {
            currentToast!!.cancel()
        }

        currentToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG)
        currentToast!!.show()
    }

    override fun onMenuItemClick(itemTitle: Int) {
        Timber.d("onMenuItemClick(itemTitle: Int)")

        val tmpItemLabel: String = getString(itemTitle)

        presenter.onMenuItemClicked(tmpItemLabel)
    }

    override fun onMenuItemClickHandled(itemTitle: String) {
        Timber.d("onMenuItemClickHandled(itemTitle: String)")

        when (itemTitle) {

            AppConstants.ABOUT_ITEM_LABEL -> AboutActivity.startFrom(this)
            AppConstants.NEWS_ITEM_LABEL -> NewsActivity.startFrom(this)
            AppConstants.PLACE_ITEM_LABEL -> PlaceActivity.startFrom(this)
            AppConstants.INFORMATION_ITEM_LABEL -> InformationActivity.startFrom(this)
            AppConstants.TICKETS_ITEM_LABEL -> TicketsActivity.startFrom(this)
            AppConstants.SADDAY_GAME_ITEM_LABEL -> GameActivity.startFrom(this)
            AppConstants.FOTO_VIDEO_ITEM_LABEL -> FotoVideoActivity.startFrom(this)
            AppConstants.ACCOUNT_ITEM_LABEL -> AccountActivity.startFrom(this)
        }
    }

    companion object {
        fun startFrom(context: Context) {
            Timber.d("startFrom(context: Context)")

            Intent(context, MainMenuActivity::class.java)
                .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP }
                .also { context.startActivity(it) }
        }
    }
}
