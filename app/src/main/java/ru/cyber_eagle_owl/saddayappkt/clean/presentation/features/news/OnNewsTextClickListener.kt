package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.news

import android.view.View
import android.widget.TextView
import ru.cyber_eagle_owl.saddayappkt.R
import timber.log.Timber

class OnNewsTextClickListener(var isExpanded: Boolean) :
    View.OnClickListener {
    override fun onClick(newsTextView: View?) {
        Timber.d("onClick(newsTextView: View?)")

        (newsTextView as TextView).also {

            if (isExpanded) {
                it.maxLines = 8
                isExpanded = false
            } else {
                it.maxLines = Integer.MAX_VALUE
                isExpanded = true
            }
        }
    }
}