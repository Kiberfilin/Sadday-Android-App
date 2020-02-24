package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_post_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import timber.log.Timber

class NewsListingRecyclerViewAdapter :
    RecyclerView.Adapter<NewsListingRecyclerViewAdapter.NewsListingViewHolder>() {

    var newsItems: List<NewsItem> = ArrayList()

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

        //Timber.d("holder.view.newsPostItemPostText.lineCount = ${holder.view.newsPostItemPostText.lineCount}")

        holder.view.newsPostItemPostText.also {
            it.setOnClickListener(OnNewsTextClickListener(holder.isExpanded))
        }
    }

    class NewsListingViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var isExpanded: Boolean = false

        fun bind(item: NewsItem) {
            Timber.d("bind(item: NewsItem)")

            view.apply {
                newsPostItemAuthorTv.text = item.newsAuthor
                newsPostItemDateTv.text = item.newsDate
                newsPostItemPostText.text = item.newsText
            }
        }
    }
}