package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.news_post_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import timber.log.Timber

class NewsListingRecyclerViewAdapter :
    RecyclerView.Adapter<NewsListingRecyclerViewAdapter.NewsListingViewHolder>() {

    var newsItems: ArrayList<NewsItem> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListingViewHolder {
        Timber.d("onCreateViewHolder()")

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.news_post_item, parent, false)
        return NewsListingViewHolder(view)
    }

    override fun getItemCount(): Int {
        Timber.d("getItemCount() ${newsItems.size}")

        return newsItems.size
    }

    override fun onBindViewHolder(holder: NewsListingViewHolder, position: Int) {
        Timber.d("onBindViewHolder()")

        holder.bind(newsItems[position])
    }

    class NewsListingViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: NewsItem) {
            Timber.d("bind(item: NewsItem)")

            val bundleOfViewParams = Bundle()

            view.apply {
                newsPostItemAuthorTv.text = item.newsAuthor
                newsPostItemDateTv.text = item.newsDate
                newsPostItemPostText.text = item.newsText

                bundleOfViewParams.putInt(TEXT_TOTAL_LINES_KEY, newsPostItemPostText.lineCount)
            }
            adaptView(bundleOfViewParams)
        }

        private fun adaptView(params: Bundle) {
            Timber.d("adaptView(params: Bundle)")

            val viewsForAdjust = HashMap<String, View>()
            val expandationState = Bundle()

            view.apply {
                params.getInt(TEXT_TOTAL_LINES_KEY).also { lineCount ->
                    newsPostItemPostText.maxLines = if (lineCount > 7) {

                        viewsForAdjust[POST_TEXT_TEXTVIEW_KEY] = newsPostItemPostText
                        expandationState.putBoolean(POST_TEXT_EXPANDATION_STATE_KEY, false)

                        newsPostItemMoreButton.visibility = View.VISIBLE
                        newsPostItemMoreButton.setOnClickListener(
                            OnMoreButtonClickListener(
                                viewsForAdjust,
                                expandationState
                            )
                        )

                        7
                    } else {
                        newsPostItemMoreButton.visibility = View.GONE
                        -1
                    }
                    Timber.d("newsPostItemPostText.maxLines = ${newsPostItemPostText.maxLines}")
                }
            }
        }

        companion object {

            private val TEXT_TOTAL_LINES_KEY: String = "TEXT_TOTAL_LINES_KEY"
            private val POST_TEXT_TEXTVIEW_KEY: String = "POST_TEXT_TEXTVIEW_KEY"
            private val POST_TEXT_EXPANDATION_STATE_KEY: String = "POST_TEXT_EXPANDATION_STATE_KEY"
        }

        private class OnMoreButtonClickListener(val viewsForAdjust: HashMap<String, View>, val expandationState: Bundle) :
            View.OnClickListener {

            override fun onClick(moreBtn: View?) {
                Timber.d("onClick(v: View?)")

                viewsForAdjust.apply {

                    (this[POST_TEXT_TEXTVIEW_KEY] as TextView).maxLines = if (expandationState.getBoolean(
                            POST_TEXT_EXPANDATION_STATE_KEY)) {
                        (moreBtn as TextView).setText(R.string.button_more_label)
                        7
                    } else {
                        (moreBtn as TextView).setText(R.string.button_less_label)
                        -1
                    }
                }
            }
        }
    }
}