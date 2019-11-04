package ru.cyber_eagle_owl.saddayappkt.constants

import com.vk.api.sdk.auth.VKScope

class VkConstants {

    companion object {

        const val BOOKING_AGENCY_GROUP_ID: Long = -154501039
        const val TEST_GROUP_ID: Long = 39575772

        val DEFAULT_LOGIN_SCOPE: ArrayList<VKScope> =
            arrayListOf(VKScope.WALL, VKScope.PHOTOS, VKScope.GROUPS, VKScope.VIDEO)

        val JSON_TO_POJO_PARSING_TAG = "Parsing to pojo"

        //val VKAPI_BASE_URL = "https://api.vk.com/method/"
        //val VKAPI_VERSION = 5.92
        const val VKAPI_DEFAULT_COUNT = 30

        //константы для параметров запросов к api
        const val VKAPI_CONST_OWNER_ID = "owner_id"
        const val VKAPI_CONST_GROUP_IDS = "group_ids"
        const val VKAPI_CONST_COUNT = "count"
        const val VKAPI_CONST_OFFSET = "offset"
        const val VKAPI_CONST_EXTENDED = "extended"
        const val VKAPI_CONST_VERSION = "version"
        const val VKAPI_CONST_ACCESS_TOKEN = "access_token"
        const val VKAPI_CONST_USER_IDS = "user_ids"

        //константы для полей pojo объектов в ответе от api
        //Для объекта FullResponse
        const val VKAPI_CONST_RESPONSE = "response"
        //константы для объекта Response
        const val VKAPI_CONST_ITEMS = "items"
        const val VKAPI_CONST_GROUPS = "groups"
        const val VKAPI_CONST_PROFILES = "profiles"
        //константы для объекта Item
        const val VKAPI_CONST_ID = "id"
        const val VKAPI_CONST_FROM_ID = "from_id"
        const val VKAPI_CONST_CREATED_BY = "created_by"
        const val VKAPI_CONST_DATE = "date"
        const val VKAPI_CONST_TEXT = "text"
        const val VKAPI_CONST_REPLY_OWNER_ID = "reply_owner_id"
        const val VKAPI_CONST_REPLY_POST_ID = "reply_post_id"
        const val VKAPI_CONST_FRIENDS_ONLY = "friends_only"
        const val VKAPI_CONST_COMMENTS = "comments"
        const val VKAPI_CONST_LIKES = "likes"
        const val VKAPI_CONST_REPOSTS = "reposts"
        const val VKAPI_CONST_VIEWS = "views"
        const val VKAPI_CONST_POST_TYPE = "post_type"
        const val VKAPI_CONST_POST_SOURCE = "post_source"
        const val VKAPI_CONST_ATTACHMENTS = "attachments"
        const val VKAPI_CONST_GEO = "geo"
        const val VKAPI_CONST_SIGNER_ID = "signer_id"
        const val VKAPI_CONST_COPY_HISTORY = "copy_history"
        const val VKAPI_CONST_CAN_PIN = "can_pin"
        const val VKAPI_CONST_CAN_DELETE = "can_delete"
        const val VKAPI_CONST_CAN_EDIT = "can_edit"
        const val VKAPI_CONST_IS_PINNED = "is_pinned"
        const val VKAPI_CONST_MARKED_AS_ADS = "marked_as_ads"
        const val VKAPI_CONST_IS_FAVORITE = "is_favorite"
        //константы для объекта Comments
        const val VKAPI_CONST_CAN_POST = "can_post"
        const val VKAPI_CONST_GROUPS_CAN_POST = "groups_can_post"
        const val VKAPI_CONST_CAN_CLOSE = "can_close"
        const val VKAPI_CONST_CAN_OPEN = "can_open"
        //константы для объекта Likes
        const val VKAPI_CONST_USER_LIKES = "user_likes"
        const val VKAPI_CONST_CAN_LIKE = "can_like"
        const val VKAPI_CONST_CAN_PUBLISH = "can_publish"
        //константы для объекта Reposts
        const val VKAPI_CONST_USER_REPOSTED = "user_reposted"
        //константы для объекта PostSource
        const val VKAPI_CONST_TYPE = "type"
        const val VKAPI_CONST_PLATFORM = "platform"
        const val VKAPI_CONST_DATA = "data"
        const val VKAPI_CONST_URL = "url"
        //константы для объекта Geo
        const val VKAPI_CONST_COORDINATES = "coordinates"
        const val VKAPI_CONST_PLACE = "place"
        //константы для объекта Place
        const val VKAPI_CONST_TITLE = "title"
        const val VKAPI_CONST_LATITUDE = "latitude"
        const val VKAPI_CONST_LONGITUDE = "longitude"
        const val VKAPI_CONST_CREATED = "created"
        const val VKAPI_CONST_ICON = "icon"
        const val VKAPI_CONST_CHECKINS = "checkins"
        const val VKAPI_CONST_UPDATED = "updated"
        const val VKAPI_CONST_COUNTRY = "country"
        const val VKAPI_CONST_CITY = "city"
        const val VKAPI_CONST_ADDRESS = "address"
        //константы для объекта Photo
        const val VKAPI_CONST_ALBUM_ID = "album_id"
        const val VKAPI_CONST_USER_ID = "user_id"
        const val VKAPI_CONST_SIZES = "sizes"
        const val VKAPI_CONST_WIDTH = "width"
        const val VKAPI_CONST_HEIGHT = "height"
        const val VKAPI_CONST_ACCESS_KEY = "access_key"
        //константы для объекта Attachment
        const val VKAPI_CONST_PHOTO = "photo"
        const val VKAPI_CONST_POSTED_PHOTO = "posted_photo"
        const val VKAPI_CONST_VIDEO = "video"
        const val VKAPI_CONST_AUDIO = "audio"
        const val VKAPI_CONST_DOC = "doc"
        const val VKAPI_CONST_GRAFFITI = "graffiti"
        const val VKAPI_CONST_LINK = "link"
        const val VKAPI_CONST_NOTE = "note"
        const val VKAPI_CONST_APP = "app"
        const val VKAPI_CONST_POLL = "poll"
        const val VKAPI_CONST_PAGE = "page"
        const val VKAPI_CONST_ALBUM = "album"
        const val VKAPI_CONST_PHOTOS_LIST = "photos_list"
        const val VKAPI_CONST_MARKET = "market"
        const val VKAPI_CONST_MARKET_ALBUM = "market_album"
        const val VKAPI_CONST_STICKER = "sticker"
        const val VKAPI_CONST_PRETTY_CARDS = "pretty_cards"
        //константы для объекта PostedPhoto
        const val VKAPI_CONST_PHOTO_130 = "photo_130"
        const val VKAPI_CONST_PHOTO_604 = "photo_604"
        //константы для объекта Video
        const val VKAPI_CONST_DESCRIPTION = "description"
        const val VKAPI_CONST_DURATION = "duration"
        const val VKAPI_CONST_PHOTO_320 = "photo_320"
        const val VKAPI_CONST_PHOTO_640 = "photo_640"
        const val VKAPI_CONST_PHOTO_800 = "photo_800"
        const val VKAPI_CONST_PHOTO_1280 = "photo_1280"
        const val VKAPI_CONST_FIRST_FRAME_130 = "first_frame_130"
        const val VKAPI_CONST_FIRST_FRAME_320 = "first_frame_320"
        const val VKAPI_CONST_FIRST_FRAME_640 = "first_frame_640"
        const val VKAPI_CONST_FIRST_FRAME_800 = "first_frame_800"
        const val VKAPI_CONST_FIRST_FRAME_1280 = "first_frame_1280"
        const val VKAPI_CONST_ADDING_DATE = "adding_date"
        const val VKAPI_CONST_PLAYER = "player"
        const val VKAPI_CONST_CAN_ADD = "can_add"
        const val VKAPI_CONST_IS_PRIVATE = "is_private"
        const val VKAPI_CONST_PROCESSING = "processing"
        const val VKAPI_CONST_LIVE = "live"
        const val VKAPI_CONST_UPCOMING = "upcoming"
        //константы для объекта Audio
        const val VKAPI_CONST_ARTIST = "artist"
        const val VKAPI_CONST_LYRICS_ID = "lyrics_id"
        const val VKAPI_CONST_GENRE_ID = "genre_id"
        const val VKAPI_CONST_NO_SEARCH = "no_search"
        const val VKAPI_CONST_IS_HQ = "is_hq"
        //константы для doc
        const val VKAPI_CONST_SIZE = "size"
        const val VKAPI_CONST_EXT = "ext"
        const val VKAPI_CONST_PREVIEW = "preview"
        //константы для объекта Preview
        const val VKAPI_CONST_AUDIO_MESSAGE = "audio_message"
        //константы для объекта PreviewGraffiti
        const val VKAPI_CONST_SRC = "src"
        //константы для объекта AudioMessage
        const val VKAPI_CONST_WAVEFORM = "waveform"
        const val VKAPI_CONST_LINK_OGG = "link_ogg"
        const val VKAPI_CONST_LINK_MP3 = "link_mp3"
        //константы для объекта Link
        const val VKAPI_CONST_CAPTION = "caption"
        const val VKAPI_CONST_PRODUCT = "product"
        const val VKAPI_CONST_BUTTON = "button"
        const val VKAPI_CONST_PREVIEW_PAGE = "preview_page"
        const val VKAPI_CONST_PREVIEW_URL = "preview_url"
        //константы для объекта Product
        const val VKAPI_CONST_PRICE = "price"
        //константы для объекта Price
        const val VKAPI_CONST_AMOUNT = "amount"
        const val VKAPI_CONST_CURRENCY = "currency"
        //константы для объекта Currency
        const val VKAPI_CONST_NAME = "name"
        //константы для объекта Button
        const val VKAPI_CONST_ACTION = "action"
        //константы для объекта Note
        const val VKAPI_CONST_READ_COMMENTS = "read_comments"
        const val VKAPI_CONST_VIEW_URL = "view_url"
        //константы для объекта Poll
        const val VKAPI_CONST_QUESTION = "question"
        const val VKAPI_CONST_VOTES = "votes"
        const val VKAPI_CONST_ANSWERS = "answers"
        const val VKAPI_CONST_ANONYMOUS = "anonymous"
        const val VKAPI_CONST_MULTIPLE = "multiple"
        const val VKAPI_CONST_ANSWER_IDS = "answer_ids"
        const val VKAPI_CONST_END_DATE = "end_date"
        const val VKAPI_CONST_CLOSED = "closed"
        const val VKAPI_CONST_IS_BOARD = "is_board"
        const val VKAPI_CONST_CAN_VOTE = "can_vote"
        const val VKAPI_CONST_CAN_REPORT = "can_report"
        const val VKAPI_CONST_CAN_SHARE = "can_share"
        const val VKAPI_CONST_AUTHOR_ID = "author_id"
        const val VKAPI_CONST_BACKGROUND = "background"
        const val VKAPI_CONST_FRIENDS = "friends"
        //константы для объекта Answer
        const val VKAPI_CONST_RATE = "rate"
        //константы для объекта Background
        const val VKAPI_CONST_ANGLE = "angle"
        const val VKAPI_CONST_COLOR = "color"
        const val VKAPI_CONST_IMAGES = "images"
        const val VKAPI_CONST_POINTS = "points"
        //константы для объекта Point
        const val VKAPI_CONST_POSITION = "position"
        //константы для объекта Group
        const val VKAPI_CONST_IS_ADMIN = "is_admin"
        const val VKAPI_CONST_IS_ADVERTISER = "is_advertiser"
        const val VKAPI_CONST_IS_CLOSED = "is_closed"
        const val VKAPI_CONST_IS_MEMBER = "is_member"
        const val VKAPI_CONST_PHOTO_100 = "photo_100"
        const val VKAPI_CONST_PHOTO_200 = "photo_200"
        const val VKAPI_CONST_PHOTO_50 = "photo_50"
        const val VKAPI_CONST_SCREEN_NAME = "screen_name"
        //константы для объекта VkUser
        const val VKAPI_CONST_CAN_ACCESS_CLOSED = "can_access_closed"
        const val VKAPI_CONST_FIRST_NAME = "first_name"
        const val VKAPI_CONST_LAST_NAME = "last_name"
        const val VKAPI_CONST_ONLINE = "online"
        const val VKAPI_CONST_ONLINE_APP = "online_app"
        const val VKAPI_CONST_ONLINE_MOBILE = "online_mobile"
        const val VKAPI_CONST_SEX = "sex"

        //константы для методов api
        const val WALL_GET_METHOD = "wall.get"
        const val USERS_GET_METHOD = "users.get"
        const val GROUPS_GET_MEMBERS_METHOD = "groups.getMembers"
        const val BOARD_GET_TOPICS_METHOD = "board.getTopics"
        const val GROUPS_GET_BY_ID_METHOD = "groups.getById"
        const val WALL_GET_BY_ID_METHOD = "wall.getById"
        const val VIDEO_GET_METHOD = "video.get"
        const val WALL_GET_COMMENTS_METHOD = "wall.getComments"
        const val BOARD_GET_COMMENTS_METHOD = "board.getComments"
        const val ACCOUNT_REGISTER_DEVICE_METHOD = "account.registerDevice"

        const val TAG_DEBUG = "0==(========>"
    }
}