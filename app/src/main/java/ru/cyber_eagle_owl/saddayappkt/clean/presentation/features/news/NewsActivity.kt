package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class NewsActivity : BaseActivity(), NewsMvp.View {

    private var currentToast: Toast? = null

    @Inject
    lateinit var presenter: NewsMvp.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")

        setContentView(R.layout.activity_news)

        prepareScreen()
        prepareToolbar()
        prepareRecyclerView()

        presenter.onViewCreated()
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

    private fun prepareRecyclerView() {
        Timber.d("prepareRecyclerView()")

        val dummyItems: ArrayList<NewsItem> = ArrayList()
        dummyItems.add(NewsItem("Талибы обстреляли НЛО", "Vasia Pupkin", "1l сентября 2001"))
        dummyItems.add(NewsItem("Талибы обстреляли НЛО", "Buratino", "1l сентября 2001"))
        dummyItems.add(NewsItem("All your base are belong to us.", "Vasia Pupkin", "1l сентября 2001"))
        dummyItems.add(NewsItem("Телефон жирафа", "Vasia Pupkin", "1l сентября 2001"))
        dummyItems.add(NewsItem("Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum Lorem ipsum, or lipsum", "Vasia Pupkin", "1l сентября 2001"))
        dummyItems.add(NewsItem("Талибы обстреляли НЛО", "Vasia Pupkin", "1l сентября 2001"))
        dummyItems.add(NewsItem("Талибы обстреляли НЛО", "Vasia Pupkin", "1l сентября 2001"))
        dummyItems.add(NewsItem("Талибы обстреляли НЛО", "Vasia Pupkin", "1l сентября 2001"))

        val tmpAdapter = NewsListingRecyclerViewAdapter()
        tmpAdapter.newsItems = dummyItems

        newsListingRecyclerView.apply {

            val dens: Float = context.resources.displayMetrics.density

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = (48 * dens).toInt()
            } else {
                (layoutParams as ViewGroup.MarginLayoutParams).marginStart = (48 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (48 * dens).toInt()
            }

            layoutManager = LinearLayoutManager(this@NewsActivity)
            this.adapter = tmpAdapter
            adapter.notifyDataSetChanged()
        }
    }

    private fun prepareToolbar() {
        Timber.d("prepareToolbar()")

        setSupportActionBar(toolbar)
        toolbar.setBackgroundResource(R.color.colorShadeForMainMenuElements)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitle(R.string.main_menu_item_title_news)
    }

    override fun showToast(toastText: String) {
        Timber.d("showToast")

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
            Intent(context, NewsActivity::class.java)
                .apply {
                    //to set some flags here, like it:
                    //flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                .also { context.startActivity(it) }
        }
    }
}