package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Group
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Item
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.VkUser
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.NewsRequest
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.VkGroupRequest
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.VkUsersRequest
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.NewsRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.NewsRepositoryOutputPort
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.utils.mappers.EntityMapper
import timber.log.Timber

class NewsRepository : NewsRepositoryInputPort {

    private lateinit var interactor: NewsRepositoryOutputPort

    override fun setOutputPort(outputPort: NewsRepositoryOutputPort) {
        Timber.d("setOutputPort(outputPort: NewsRepositoryOutputPort)")

        interactor = outputPort
    }

    override fun getNews() {
        Timber.d("getNews()")

        startGettingNews()
    }

    private fun startGettingNews() {
        Timber.d("startGettingNews()")

        VK.execute(NewsRequest(), object : VKApiCallback<List<Item?>?> {
            override fun fail(error: Exception) {
                Timber.d(error)
            }

            override fun success(result: List<Item?>?) {

                val authorIds = StringBuilder("")
                if (result != null) {
                    for (i in 0 until result.size) {
                        result[i]?.run {
                            signerId?.let {
                                if (!authorIds.contains(it.toString())) authorIds.append(",$it")
                            }
                        }
                    }
                    if (authorIds.toString() != "") authorIds.deleteCharAt(0)
                    Timber.d("authorIds.toString(): $authorIds")
                }

                if (authorIds.toString() != "") {
                    startGettingAuthors(result, authorIds)
                } else {
                    startGettingGroupName(result, null)
                }
            }
        })
    }

    private fun startGettingAuthors(news: List<Item?>?, authorIds: StringBuilder) {
        Timber.d("startGettingAuthors(result: List<Item?>?, authorIds: StringBuilder)")

        VK.execute(VkUsersRequest(authorIds.toString()), object : VKApiCallback<List<VkUser?>?> {
            override fun fail(error: Exception) {
                Timber.d(error)
            }

            override fun success(result: List<VkUser?>?) {
                startGettingGroupName(news, result)
            }
        })
    }

    private fun startGettingGroupName(news: List<Item?>?, users: List<VkUser?>?) {
        Timber.d("startGettingGroupName(news: List<Item?>?, bookingAgencyGroupId: Long)")

        val tmpGroupId: StringBuilder = StringBuilder(VkConstants.BOOKING_AGENCY_GROUP_ID.toString())
        tmpGroupId.delete(0, 1)

        VK.execute(VkGroupRequest(tmpGroupId.toString()), object : VKApiCallback<Group?> {
            override fun fail(error: Exception) {
                Timber.d(error)
            }

            override fun success(result: Group?) {
                interactor.onNewsHasGotten(EntityMapper.mapToNewsItems(news, users, result))
            }
        })
    }
}