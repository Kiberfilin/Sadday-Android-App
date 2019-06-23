package ru.cyber_eagle_owl.saddayappkt.clean.data.repositories

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Group
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.Item
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.VkUser
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation.NewsItem
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.NewsRequest
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.VkGroupRequest
import ru.cyber_eagle_owl.saddayappkt.clean.data.web.VkUsersRequest
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.inputports.NewsRepositoryInputPort
import ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.repository.outputports.NewsRepositoryOutputPort
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.utils.EntityMapper
import timber.log.Timber
import kotlin.text.StringBuilder

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
            override fun fail(error: VKApiExecutionException) {
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
            override fun fail(error: VKApiExecutionException) {
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
            override fun fail(error: VKApiExecutionException) {
                Timber.d(error)
            }

            override fun success(result: Group?) {
                interactor.onNewsHasGotten(EntityMapper.mapToNewsItems(news, users, result))
            }

        })

    }

    private fun createDummyData(): ArrayList<NewsItem> {
        Timber.d("createDummyData(): ArrayList<NewsItem>")

        val dummyItems: ArrayList<NewsItem> = ArrayList()
        dummyItems.add(
            NewsItem(
                "Талибы обстреляли НЛО",
                "Vasia Pupkin",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "Талибы обстреляли НЛО",
                "Buratino",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "All your base are belong to us.",
                "Vasia Pupkin",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "Телефон жирафа",
                "Vasia Pupkin",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Why do we use it? It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \\'Content here, content here\\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \\'lorem ipsum\\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). Where does it come from? Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham. Where can I get some? There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don\\'t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn\\'t anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
                "Vasia Pupkin",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "Талибы обстреляли НЛО",
                "Vasia Pupkin Vasia Pupkin Vasia Pupkin Vasia Pupkin Vasia Pupkin Vasia Pupkin Vasia Pupkin Vasia Pupkin Vasia Pupkin ",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "Dependency Rule\n" +
                        "\n" +
                        "Dependency Rule говорит нам, что внутренние слои не должны зависеть от внешних. То есть наша бизнес-логика и логика приложения не должны зависеть от презентеров, UI, баз данных и т.п. На оригинальной схеме это правило изображено стрелками, указывающими внутрь.\n" +
                        "\n" +
                        "\n" +
                        "В статье сказано: имена сущностей (классов, функций, переменных, чего угодно), объявленных во внешних слоях, не должны встречаться в коде внутренних слоев.\n" +
                        "\n" +
                        "\n" +
                        "Это правило позволяет строить системы, которые будет проще поддерживать, потому что изменения во внешних слоях не затронут внутренние слои.",
                "Vasia Pupkin",
                "1l сентября 2001"
            )
        )
        dummyItems.add(
            NewsItem(
                "Талибы обстреляли НЛО",
                "Vasia Pupkin",
                "1l сентября 2001"
            )
        )

        return dummyItems
    }
}