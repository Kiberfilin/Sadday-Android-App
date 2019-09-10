package ru.cyber_eagle_owl.saddayappkt.utils


import android.annotation.SuppressLint
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Group
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Item
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.VkUser
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import timber.log.Timber
import java.text.SimpleDateFormat

class EntityMapper {

    companion object {


        @SuppressLint("SimpleDateFormat")
        fun mapToNewsItems(items: List<Item?>?, authors: List<VkUser?>?, group: Group?): List<NewsItem> {
            Timber.d("mapToNewsItems(items: List<Item?>?): List<NewsItem>")

            val newsItems: ArrayList<NewsItem> = ArrayList()


            items?.let {
                for (i in 0 until it.size) {

                    if (it[i] == null) continue else {

                        val tmpNewsText: String = if (it[i]!!.text != null) it[i]!!.text!! else ""

                        val tmpNewsAuthor: String = when {
                            (it[i]!!.signerId != null && it[i]!!.signerId!! > 0) -> getAuthorString(
                                it[i]!!.signerId!!,
                                authors
                            )
                            group?.screenName != null -> group.name.toString()
                            else -> ""
                        }

                        val sdf = SimpleDateFormat("kk:mm dd.MM.yyyy")
                        val tmpNewsDate = if (it[i]!!.date != null) {
                            sdf.format(java.util.Date(it[i]!!.date!! * 1000))
                        } else ""

                        newsItems.add(NewsItem(tmpNewsText, tmpNewsAuthor, tmpNewsDate))
                    }
                }
            }
            return newsItems
        }

        private fun getAuthorString(fromId: Long, authors: List<VkUser?>?): String {
            Timber.d("getAuthorString(fromId: Long): String")

            val authorString: StringBuilder = StringBuilder("")

            if (authors != null && authors.isNotEmpty()) {
                for (author in authors) {
                    if (author != null && author.id == fromId) {
                        Timber.d("${author.firstName} ${author.lastName}")
                        authorString.append("${author.firstName} ${author.lastName}")
                    }
                }
            }

            return authorString.toString()
        }
    }
}