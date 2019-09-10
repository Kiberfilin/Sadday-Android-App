package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.base.BaseActivity
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import timber.log.Timber
import javax.inject.Inject

class NewsActivity : BaseActivity(), NewsMvp.View {
    private var currentToast: Toast? = null

    @Inject
    lateinit var presenter: NewsMvp.Presenter

    private lateinit var newsAdapter: NewsListingRecyclerViewAdapter

    private lateinit var onRefreshListener: SwipeRefreshLayout.OnRefreshListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")


        setContentView(R.layout.activity_news)
        prepareScreen()

        val dens: Float = this.resources.displayMetrics.density

        prepareToolbar(resources.configuration.orientation, dens)
        prepareRecyclerView(resources.configuration.orientation, dens)

        prepareSwipeRefreshLayout()
        presenter.onViewCreated()
        newsListingSwipeRefresh.isRefreshing = true
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

    private fun prepareRecyclerView(orientation: Int, dens: Float) {
        Timber.d("prepareRecyclerView()")

        newsAdapter = NewsListingRecyclerViewAdapter()

        //newsListingRecyclerView.apply {
        newsListingSwipeRefresh?.apply {

            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = (48 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginStart = (8 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (8 * dens).toInt()
            } else {
                (layoutParams as ViewGroup.MarginLayoutParams).marginStart = (48 * dens).toInt()
                (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (48 * dens).toInt()
            }

            newsListingRecyclerView.layoutManager = LinearLayoutManager(this@NewsActivity)
            newsListingRecyclerView.adapter = newsAdapter
            newsListingRecyclerView.adapter.notifyDataSetChanged()
        }
    }

    private fun prepareToolbar(orientation: Int, dens: Float) {
        Timber.d("prepareToolbar()")

        setSupportActionBar(toolbar)
        toolbar.setBackgroundResource(R.color.colorShadeForFrontEndElements)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitle(R.string.main_menu_item_title_news)

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).marginStart = (48 * dens).toInt()
            (toolbar.layoutParams as ViewGroup.MarginLayoutParams).marginEnd = (48 * dens).toInt()
        }
    }

    override fun onNewsHasGotten(news: List<NewsItem>) {
        Timber.d("onNewsHasGotten(news: ArrayList<NewsItem>)")

        newsAdapter.newsItems = news
        newsAdapter.notifyDataSetChanged()
        newsListingSwipeRefresh.isRefreshing = false
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

    private fun prepareSwipeRefreshLayout() {
        Timber.d("showToast")

        onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
            presenter.onNewsRefreshingStarted()
        }

        newsListingSwipeRefresh.setOnRefreshListener(onRefreshListener)
    }

    companion object {
        fun startFrom(context: Context) {
            Intent(context, NewsActivity::class.java)
                .apply {
                    //to set some flags here, like it:
                    //flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }.also { context.startActivity(it) }
        }
    }
}