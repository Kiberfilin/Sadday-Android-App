package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.poll

import java.util.ArrayList
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.Attachable
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo.Photo
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.poll.bacground.Background
import timber.log.Timber

class Poll(
    var id: Long?,
    var ownerId: Long?,
    var created: Long?,
    var question: String?,
    var votes: Long?,
    var answers: List<Answer?>?,
    var anonymous: Boolean?,
    var multiple: Boolean?,
    var answerIds: List<Int?>?,
    var endDate: Long?,
    var closed: Boolean?,
    var board: Boolean?,
    var canEdit: Boolean?,
    var canVote: Boolean?,
    var canReport: Boolean?,
    var canShare: Boolean?,
    var authorId: Long?,
    var photo: Photo?,
    var background: Background?,
    var friends: List<Long?>?
) : Attachable {

    companion object {

        fun parse(jsonObject: JSONObject?): Poll? {
            Timber.d("Парсим ${Poll::class.java.simpleName} Получили такой JSONObject $jsonObject")

            if (jsonObject != null) {

                val tmpJsonArrayOfAnswers = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_ANSWERS)
                var tmpAnswers: ArrayList<Answer?>? = null

                if (tmpJsonArrayOfAnswers != null) {
                    tmpAnswers = ArrayList()
                    for (i in 0 until tmpJsonArrayOfAnswers.length()) {
                        val tmpJSONObject = tmpJsonArrayOfAnswers.optJSONObject(i)
                            tmpAnswers.add(Answer.parse(tmpJSONObject))
                    }
                }

                val tmpJsonArrayOfAnswerIds = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_ANSWER_IDS)
                var tmpAnswerIds: ArrayList<Int?>? = null

                if (tmpJsonArrayOfAnswerIds != null) {
                    tmpAnswerIds = ArrayList()
                    for (i in 0 until tmpJsonArrayOfAnswerIds.length()) {
                        tmpAnswerIds.add(tmpJsonArrayOfAnswerIds.optInt(i))
                    }
                }

                val tmpJsonArrayOfFriends = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_FRIENDS)
                var tmpFriends: ArrayList<Long?>? = null

                if (tmpJsonArrayOfFriends != null) {
                    tmpFriends = ArrayList()
                    for (i in 0 until tmpJsonArrayOfFriends.length()) {
                        tmpFriends.add(tmpJsonArrayOfFriends.optLong(i))
                    }
                }

                return Poll(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_OWNER_ID),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_CREATED),
                    jsonObject.optString(VkConstants.VKAPI_CONST_QUESTION),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_VOTES),
                    tmpAnswers,
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_ANONYMOUS),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_MULTIPLE),
                    tmpAnswerIds,
                    jsonObject.optLong(VkConstants.VKAPI_CONST_END_DATE),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_CLOSED),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_IS_BOARD),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_CAN_EDIT),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_CAN_VOTE),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_CAN_REPORT),
                    jsonObject.optBoolean(VkConstants.VKAPI_CONST_CAN_SHARE),
                    jsonObject.optLong(VkConstants.VKAPI_CONST_AUTHOR_ID),
                    Photo.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_PHOTO)),
                    Background.parse(jsonObject.optJSONObject(VkConstants.VKAPI_CONST_BACKGROUND)),
                    tmpFriends
                )
            } else {
                return null
            }
        }
    }
}
