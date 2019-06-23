package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.poll.bacground

import java.util.ArrayList
import org.json.JSONObject
import ru.cyber_eagle_owl.saddayappkt.clean.data.entities.data.attachments.photo.size.Size
import ru.cyber_eagle_owl.saddayappkt.constants.VkConstants
import timber.log.Timber

class Background(
    var id: Long?,
    var type: String?,
    var angle: Int?,
    var color: String?,
    var width: Int?,
    var height: Int?,
    var images: List<Size?>?,
    var points: List<Point?>?
) {

    companion object {

        fun parse(jsonObject: JSONObject?): Background? {
            Timber.d("Парсим ${Background::class.java.simpleName} Получили такой JSONObject $jsonObject")

            if (jsonObject != null) {

                val tmpJsonArrayOfImages = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_IMAGES)
                var tmpImages: ArrayList<Size?>? = null

                if (tmpJsonArrayOfImages != null) {
                    tmpImages = ArrayList()
                    for (i in 0 until tmpJsonArrayOfImages.length()) {
                        val tmpJSONObject = tmpJsonArrayOfImages.optJSONObject(i)
                        tmpImages.add(Size.parse(tmpJSONObject))
                    }
                }

                val tmpJsonArrayOfPoints = jsonObject.optJSONArray(VkConstants.VKAPI_CONST_POINTS)
                var tmpPoints: ArrayList<Point?>? = null

                if (tmpJsonArrayOfPoints != null) {
                    tmpPoints = ArrayList()
                    for (i in 0 until tmpJsonArrayOfPoints.length()) {
                        val tmpJSONObject = tmpJsonArrayOfPoints.optJSONObject(i)
                        tmpPoints.add(Point.parse(tmpJSONObject))
                    }
                }

                return Background(
                    jsonObject.optLong(VkConstants.VKAPI_CONST_ID),
                    jsonObject.optString(VkConstants.VKAPI_CONST_TYPE),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_ANGLE),
                    jsonObject.optString(VkConstants.VKAPI_CONST_COLOR),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_WIDTH),
                    jsonObject.optInt(VkConstants.VKAPI_CONST_HEIGHT),
                    tmpImages,
                    tmpPoints
                )
            } else {
                return null
            }
        }
    }
}
