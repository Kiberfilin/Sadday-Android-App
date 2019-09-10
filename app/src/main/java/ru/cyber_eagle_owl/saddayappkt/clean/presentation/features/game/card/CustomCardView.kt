package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.card

import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import ru.cyber_eagle_owl.saddayappkt.R
import timber.log.Timber

class CustomCardView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    //region card size ratio
    private val contentWidth = 318
    private val imgHeight = 255
    private val descriptionHeight = 164
    private val cardNameHeight = 50
    private val borderWidth = 16
    private val shortAndSpecAbilityDescriptionTopMargin = 5
    private val shortAndSpecAbilityDescriptionWith = 292
    private val cardStatsTextWidth = 220
    private val cardStatsValueWidth = 70
    private val cardStatsRowBottomMargin = 5
    private val cardWidth = 2 * borderWidth + contentWidth
    private val cardHeight = imgHeight + descriptionHeight + cardNameHeight + 2 * borderWidth

    private val cardNameTextSize = 30
    private val shortDescriptionSize = 23
    private val specAbilityDescriptionSize = 13
    private val cardStatsTextSize = 16
    private val cardStatsValueSize = 16
    //endregion

    //region Bitmap decode options
    private val compressOptions = BitmapFactory.Options().apply {
        inSampleSize = 2
    }
    //endregion

    //region strings
    private val rockPowerText = "Rock Power"
    private val maxAlcoholDigestibilityText = "Maximum alcohol digestibility"
    private val acousticBrainProtectionText = "Acoustic brain protection"
    //endregion

    //region Paints
    private val cardPaint = Paint()
    private val contentPaint = Paint()
    private val cardNameTextPaint = TextPaint()
    private val descriptionBacgroundPaint = Paint()
    private val shortDescriptionPaint = TextPaint()
    private val specAbilityDescriptionPaint = TextPaint()
    private val cardStatsTextPaint = TextPaint()
    private val cardStatsValuePaint = TextPaint()
    //endregion

    private val dens = resources.displayMetrics.density
    private lateinit var descriptionBackgroundBitmap: Bitmap

    //region different shapes
    private lateinit var cardArea: Rect
    private lateinit var pictureArea: Rect
    private lateinit var cardNameTextArea: Rect
    private lateinit var descriptionArea: Rect
    private lateinit var shortDescriptionArea: Rect
    private lateinit var specAbilityDescriptionArea: Rect
    private var rockPowerTextArea = Rect()
    private var rockPowerValueArea = Rect()
    private var maxAlcoholDigestibilityTextArea = Rect()
    private var maxAlcoholDigestibilityValueArea = Rect()
    private var acousticBrainProtectionTextArea = Rect()
    private var acousticBrainProtectionValueArea = Rect()
    private lateinit var tmpRectF: RectF
    //endregion

    //region text coordinates
    private val cardNameTextPoint = PointF(0f, 0f)
    private val shortDescriptionTextPoint = PointF(0f, 0f)
    private val specAbilityDescriptionTextPoint = PointF(0f, 0f)
    private var rockPowerTextPoint = PointF(0f, 0f)
    private var rockPowerValuePoint = PointF(0f, 0f)
    private var maxAlcoholDigestibilityTextPoint = PointF(0f, 0f)
    private var maxAlcoholDigestibilityValuePoint = PointF(0f, 0f)
    private var acousticBrainProtectionTextPoint = PointF(0f, 0f)
    private var acousticBrainProtectionValuePoint = PointF(0f, 0f)

    //endregion

    //region layouts
    private lateinit var cardNameLayout: StaticLayout
    private lateinit var shortDescriptionLayout: StaticLayout
    private lateinit var specAbilityDescriptionLayout: StaticLayout
    private lateinit var rockPowerTextLayout: StaticLayout
    private lateinit var rockPowerValueLayout: StaticLayout
    private lateinit var maxAlcoholDigestibilityTextLayout: StaticLayout
    private lateinit var maxAlcoholDigestibilityValueLayout: StaticLayout
    private lateinit var acousticBrainProtectionTextLayout: StaticLayout
    private lateinit var acousticBrainProtectionValueLayout: StaticLayout
    //endregion

    private lateinit var cardImageBitmap: Bitmap
    private var cardCorners = 0.0f


    //region выставляемые параметры
    var cardImage: Int = R.drawable.logo
        set(value) {
            Timber.d("setting var cardImage ")
            //cardImageBitmap = BitmapFactory.decodeResource(resources, value, compressOptions)
            field = value
            invalidate()
        }
    var cardName: String = ""
    var shortDescriptionText: String = ""
    var specAbilityDescriptionText: String = ""
    //region card stats
    var rockPowerValue: Int = -1
    var maxAlcoholDigestibilityValue: Int = -1
    var acousticBrainProtectionValue: Int = -1
    //endregion
    //endregion

    init {
        //region settable properties initialization
        Timber.d("Settable properties initialization in progress")
        val stylableAttr = context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomCardView, 0, 0)

        for (i in 0..stylableAttr.indexCount) {
            when (stylableAttr.getIndex(i)) {
                R.styleable.CustomCardView_cardImage -> {
                    cardImageBitmap = BitmapFactory.decodeResource(
                        resources,
                        stylableAttr.getResourceId(R.styleable.CustomCardView_cardImage, R.drawable.logo),
                        compressOptions
                    )
                }
                R.styleable.CustomCardView_cardName -> {
                    cardName = resources.getString(stylableAttr.getResourceId(R.styleable.CustomCardView_cardName, 0))
                }
                R.styleable.CustomCardView_shortDescriptionText -> {
                    shortDescriptionText =
                        resources.getString(
                            stylableAttr.getResourceId(
                                R.styleable.CustomCardView_shortDescriptionText,
                                0
                            )
                        )
                }
                R.styleable.CustomCardView_specAbilityDescriptionText -> {
                    specAbilityDescriptionText =
                        resources.getString(
                            stylableAttr.getResourceId(
                                R.styleable.CustomCardView_specAbilityDescriptionText,
                                0
                            )
                        )
                }
                R.styleable.CustomCardView_rockPowerValue -> {
                    rockPowerValue = stylableAttr.getInt(R.styleable.CustomCardView_rockPowerValue, 0)
                }
                R.styleable.CustomCardView_maxAlcoholDigestibilityValue -> {
                    maxAlcoholDigestibilityValue =
                        stylableAttr.getInt(R.styleable.CustomCardView_maxAlcoholDigestibilityValue, 0)
                }
                R.styleable.CustomCardView_acousticBrainProtectionValue -> {
                    acousticBrainProtectionValue =
                        stylableAttr.getInt(R.styleable.CustomCardView_acousticBrainProtectionValue, 0)
                }
            }
        }

        stylableAttr.recycle()
        //endregion

        /*cardImageBitmap = BitmapFactory.decodeResource(
            resources,
            stylableAttr.getResourceId(R.styleable.CustomCardView_cardImage, R.drawable.logo)
        )
        Timber.d(
            "*************** ${resources.getString(
                stylableAttr.getResourceId(
                    R.styleable.CustomCardView_cardName,
                    0
                )
            )}"
        )
        cardName = resources.getString(stylableAttr.getResourceId(R.styleable.CustomCardView_cardName, 0))
        shortDescriptionText =
            resources.getString(stylableAttr.getResourceId(R.styleable.CustomCardView_shortDescriptionText, 0))
        specAbilityDescriptionText =
            resources.getString(stylableAttr.getResourceId(R.styleable.CustomCardView_specAbilityDescriptionText, 0))
        rockPowerValue = stylableAttr.getInt(R.styleable.CustomCardView_rockPowerValue, 0)
        maxAlcoholDigestibilityValue = stylableAttr.getInt(R.styleable.CustomCardView_maxAlcoholDigestibilityValue, 0)
        acousticBrainProtectionValue = stylableAttr.getInt(R.styleable.CustomCardView_acousticBrainProtectionValue, 0)
        stylableAttr.recycle()
        Timber.d("Settable properties initialization ended")*/


        cardPaint.run {
            color = resources.getColor(R.color.colorCardGray)
            strokeWidth = 10f
        }
        cardNameTextPaint.run {
            color = resources.getColor(R.color.colorCardNameText)
            isAntiAlias = true
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        contentPaint.run {
            color = Color.LTGRAY
            strokeWidth = 3f
            style = Paint.Style.STROKE
        }
        descriptionBacgroundPaint.run {
            color = resources.getColor(R.color.colorCardDescriptionBackground)
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 3f
        }
        shortDescriptionPaint.run {
            isAntiAlias = true
            color = resources.getColor(R.color.colorCardPrimaryText)
        }
        specAbilityDescriptionPaint.run {
            isAntiAlias = true
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC)
            color = resources.getColor(R.color.colorCardPrimaryText)
        }
        cardStatsTextPaint.run {
            isAntiAlias = true
            color = resources.getColor(R.color.colorCardPrimaryText)
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
        }
        cardStatsValuePaint.run {
            isAntiAlias = true
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthSize = when (MeasureSpec.getMode(widthMeasureSpec)) {
            MeasureSpec.UNSPECIFIED -> cardWidth * dens
            else -> MeasureSpec.getSize(widthMeasureSpec).toFloat()
        }

        val pointValue = widthSize / (cardWidth)
        val heightSize = pointValue * cardHeight

        setMeasuredDimension(widthSize.toInt(), heightSize.toInt())

        val cardBorderOffset = pointValue * borderWidth

        prepareCardArea(widthSize, heightSize)
        preparePictureArea(pointValue, cardBorderOffset)
        prepareCardNameTextArea(pointValue, cardBorderOffset)
        prepareDescriptionArea(pointValue, cardBorderOffset)
        prepareBitmaps(pointValue)
        prepareShortDescription(pointValue)
        prepareSpecAbilityDescription(pointValue)
        prepareCardStats(pointValue)
    }

    private fun prepareBitmaps(pointValue: Float) {

        var sourceWidth: Int

        compressOptions.tuneForBoundsGetting()
        BitmapFactory.decodeResource(resources, R.drawable.logo, compressOptions)
        sourceWidth = compressOptions.outWidth
        compressOptions.tuneForBitmapPreparation(sourceWidth, contentWidth, pointValue)
        descriptionBackgroundBitmap = BitmapFactory.decodeResource(resources, R.drawable.logo, compressOptions)

        compressOptions.tuneForBoundsGetting()
        BitmapFactory.decodeResource(resources, cardImage, compressOptions)
        sourceWidth = compressOptions.outWidth
        compressOptions.tuneForBitmapPreparation(sourceWidth, contentWidth, pointValue)
        cardImageBitmap = BitmapFactory.decodeResource(resources, cardImage, compressOptions)
    }

    private fun BitmapFactory.Options.tuneForBoundsGetting() {
        this.apply {
            inJustDecodeBounds = true
            inScaled = false
            inDensity = 0
            inTargetDensity = 0
        }
    }

    private fun BitmapFactory.Options.tuneForBitmapPreparation(sourceWidth: Int, outWidth: Int, pointValue: Float) {
        this.apply {
            inJustDecodeBounds = false
            inScaled = true
            inDensity = sourceWidth
            inTargetDensity = inSampleSize * outWidth * pointValue.toInt()
        }
    }

    private fun prepareCardNameTextArea(pointValue: Float, cardBorderOffset: Float) {
        cardNameTextPaint.textSize = cardNameTextSize * pointValue

        val cardNameTextHeight = getTextHeight(cardName, cardNameTextPaint)

        val cardNameTextXOffset = cardBorderOffset.toInt()
        val cardNameTextYOffset =
            (pointValue * (borderWidth + imgHeight + (cardNameHeight - cardNameTextHeight / pointValue) / 2)).toInt()
        val cardNameTextRight = cardNameTextXOffset + (pointValue * contentWidth).toInt()
        val cardNameTextBottom = cardNameTextYOffset + cardNameTextHeight

        cardNameTextArea =
            Rect(cardNameTextXOffset, cardNameTextYOffset, cardNameTextRight, cardNameTextBottom)

        cardNameLayout =
            StaticLayout(
                cardName,
                cardNameTextPaint,
                (contentWidth * pointValue).toInt(),
                Layout.Alignment.ALIGN_CENTER,
                1f,
                0f,
                false
            )

        cardNameTextPoint.x = cardNameTextArea.left.toFloat()
        cardNameTextPoint.y = cardNameTextArea.exactCenterY() - cardNameTextHeight / 2
    }

    private fun prepareCardStats(pointValue: Float) {

        cardStatsTextPaint.textSize = cardStatsTextSize * pointValue
        cardStatsValuePaint.textSize = cardStatsValueSize * pointValue

        prepareCardStatRow(
            pointValue,
            cardStatsTextPaint,
            cardStatsValuePaint,
            rockPowerText,
            rockPowerValue,
            rockPowerTextArea,
            rockPowerValueArea
        )

        prepareCardStatRow(
            pointValue,
            cardStatsTextPaint,
            cardStatsValuePaint,
            maxAlcoholDigestibilityText,
            maxAlcoholDigestibilityValue,
            maxAlcoholDigestibilityTextArea,
            maxAlcoholDigestibilityValueArea
        )

        prepareCardStatRow(
            pointValue,
            cardStatsTextPaint,
            cardStatsValuePaint,
            acousticBrainProtectionText,
            acousticBrainProtectionValue,
            acousticBrainProtectionTextArea,
            acousticBrainProtectionValueArea
        )
    }

    private fun prepareCardStatRow(
        pointValue: Float,
        cardStatsTextPaint: TextPaint,
        cardStatsValuePaint: TextPaint,
        cardStatText: String,
        cardStatValue: Int,
        cardStatTextArea: Rect,
        cardStatValueArea: Rect
    ) {
        val cardStatTextHeight = getTextHeight(cardStatText, cardStatsTextPaint)
        val cardStatValueTextHeight =
            getTextHeight(if (cardStatValue == -1) "immune" else cardStatValue.toString(), cardStatsValuePaint)
        val cardStatOffsetY: Int
        val tmpCardStatTextLayout = StaticLayout(
            cardStatText,
            cardStatsTextPaint,
            (cardStatsTextWidth * pointValue).toInt(),
            Layout.Alignment.ALIGN_NORMAL,
            0.8f,
            0f,
            false
        )

        val tmpCardStatValueLayout = StaticLayout(
            if (cardStatValue == -1) "immune" else cardStatValue.toString(),
            cardStatsValuePaint,
            (cardStatsValueWidth * pointValue).toInt(),
            Layout.Alignment.ALIGN_OPPOSITE,
            0.8f,
            0f,
            false
        )

        val tmpCardStatTextPoint = PointF(0f, 0f)
        val tmpCardStatValuePoint = PointF(0f, 0f)

        when (cardStatText) {
            rockPowerText -> {
                cardStatOffsetY = (cardStatsRowBottomMargin * pointValue).toInt()
                rockPowerTextLayout = tmpCardStatTextLayout
                rockPowerValueLayout = tmpCardStatValueLayout
                rockPowerTextPoint = tmpCardStatTextPoint
                rockPowerValuePoint = tmpCardStatValuePoint
            }
            maxAlcoholDigestibilityText -> {
                cardStatOffsetY = cardStatTextHeight + 2 * (cardStatsRowBottomMargin * pointValue).toInt()
                maxAlcoholDigestibilityTextLayout = tmpCardStatTextLayout
                maxAlcoholDigestibilityValueLayout = tmpCardStatValueLayout
                maxAlcoholDigestibilityTextPoint = tmpCardStatTextPoint
                maxAlcoholDigestibilityValuePoint = tmpCardStatValuePoint
            }
            acousticBrainProtectionText -> {
                cardStatOffsetY = 2 * cardStatTextHeight + 3 * (cardStatsRowBottomMargin * pointValue).toInt()
                acousticBrainProtectionTextLayout = tmpCardStatTextLayout
                acousticBrainProtectionValueLayout = tmpCardStatValueLayout
                acousticBrainProtectionTextPoint = tmpCardStatTextPoint
                acousticBrainProtectionValuePoint = tmpCardStatValuePoint
            }
            else -> throw IllegalArgumentException("Wrong card stat text!!!")
        }

        prepareAreas(cardStatOffsetY, pointValue, cardStatTextHeight, cardStatTextArea, cardStatValueArea)

        tmpCardStatTextPoint.x = cardStatTextArea.left.toFloat()
        tmpCardStatTextPoint.y = cardStatTextArea.exactCenterY() - cardStatTextHeight / 2
        tmpCardStatValuePoint.x = cardStatValueArea.left.toFloat()
        tmpCardStatValuePoint.y = cardStatValueArea.exactCenterY() - cardStatValueTextHeight / 2
    }

    private fun prepareAreas(
        cardStatOffsetY: Int,
        pointValue: Float,
        cardStatTextHeight: Int,
        cardStatTextArea: Rect,
        cardStatValueArea: Rect
    ) {

        val cardStatTextXOffset =
            (pointValue * (borderWidth + (contentWidth - cardStatsTextWidth - cardStatsValueWidth) / 2)).toInt()
        val cardStatTextYOffset =
            (pointValue * (borderWidth + imgHeight + cardNameHeight + 2 * shortAndSpecAbilityDescriptionTopMargin)).toInt() + shortDescriptionArea.height() + specAbilityDescriptionArea.height() + cardStatOffsetY
        val cardStatTextRight =
            cardStatTextXOffset + (pointValue * cardStatsTextWidth).toInt()
        val cardStatTextBottom = cardStatTextYOffset + cardStatTextHeight

        cardStatTextArea.set(
            cardStatTextXOffset,
            cardStatTextYOffset,
            cardStatTextRight,
            cardStatTextBottom
        )

        val cardStatValueXOffset =
            cardStatTextXOffset + (cardStatsTextWidth * pointValue).toInt()
        val cardStatValueRight =
            cardStatTextRight + (pointValue * cardStatsValueWidth).toInt()

        cardStatValueArea.set(
            cardStatValueXOffset,
            cardStatTextYOffset,
            cardStatValueRight,
            cardStatTextBottom
        )
    }

    private fun prepareSpecAbilityDescription(pointValue: Float) {

        specAbilityDescriptionPaint.textSize = specAbilityDescriptionSize * pointValue

        val specAbilityDescriptionTextHeight = getTextHeight(specAbilityDescriptionText, specAbilityDescriptionPaint)

        val specAbilityDescriptionXOffset =
            (pointValue * (borderWidth + (contentWidth - shortAndSpecAbilityDescriptionWith) / 2)).toInt()
        val specAbilityDescriptionYOffset =
            (pointValue * (borderWidth + imgHeight + cardNameHeight + 2 * shortAndSpecAbilityDescriptionTopMargin)).toInt() + shortDescriptionArea.height()
        val specAbilityDescriptionRight =
            specAbilityDescriptionXOffset + (pointValue * shortAndSpecAbilityDescriptionWith).toInt()
        val specAbilityDescriptionBottom = specAbilityDescriptionYOffset + 2 * specAbilityDescriptionTextHeight

        specAbilityDescriptionArea =
            Rect(
                specAbilityDescriptionXOffset,
                specAbilityDescriptionYOffset,
                specAbilityDescriptionRight,
                specAbilityDescriptionBottom
            )

        specAbilityDescriptionLayout =
            StaticLayout(
                specAbilityDescriptionText,
                specAbilityDescriptionPaint,
                (shortAndSpecAbilityDescriptionWith * pointValue).toInt(),
                Layout.Alignment.ALIGN_NORMAL,
                0.8f,
                0f,
                false
            )

        specAbilityDescriptionTextPoint.x = specAbilityDescriptionArea.left.toFloat()
        specAbilityDescriptionTextPoint.y =
            specAbilityDescriptionArea.exactCenterY() - ((specAbilityDescriptionLayout.lineCount * specAbilityDescriptionTextHeight) / 2)
    }

    private fun prepareShortDescription(pointValue: Float) {

        shortDescriptionPaint.textSize = shortDescriptionSize * pointValue

        val shortDescriptionTextHeight = getTextHeight(shortDescriptionText, shortDescriptionPaint)

        val shortDescriptionXOffset =
            (pointValue * (borderWidth + (contentWidth - shortAndSpecAbilityDescriptionWith) / 2)).toInt()
        val shortDescriptionYOffset =
            (pointValue * (borderWidth + imgHeight + cardNameHeight + shortAndSpecAbilityDescriptionTopMargin)).toInt()
        val shortDescriptionRight = shortDescriptionXOffset + (pointValue * shortAndSpecAbilityDescriptionWith).toInt()
        val shortDescriptionBottom = shortDescriptionYOffset + 2 * shortDescriptionTextHeight

        shortDescriptionArea =
            Rect(shortDescriptionXOffset, shortDescriptionYOffset, shortDescriptionRight, shortDescriptionBottom)

        shortDescriptionLayout =
            StaticLayout(
                shortDescriptionText,
                shortDescriptionPaint,
                (shortAndSpecAbilityDescriptionWith * pointValue).toInt(),
                Layout.Alignment.ALIGN_CENTER,
                0.7f,
                0f,
                false
            )

        shortDescriptionTextPoint.x = shortDescriptionArea.left.toFloat()
        shortDescriptionTextPoint.y =
            shortDescriptionArea.exactCenterY() - ((shortDescriptionLayout.lineCount * shortDescriptionTextHeight) / 2)
    }

    private fun prepareDescriptionArea(pointValue: Float, cardBorderOffset: Float) {
        descriptionArea = Rect(
            cardBorderOffset.toInt(),
            (pointValue * (borderWidth + imgHeight + cardNameHeight)).toInt(),
            (contentWidth * pointValue).toInt() + cardBorderOffset.toInt(),
            (pointValue * (borderWidth + imgHeight + cardNameHeight)).toInt() + (descriptionHeight * pointValue).toInt()
        )
    }

    private fun preparePictureArea(pointValue: Float, cardBorderOffset: Float) {
        pictureArea = Rect(
            cardBorderOffset.toInt(),
            cardBorderOffset.toInt(),
            (contentWidth * pointValue).toInt() + cardBorderOffset.toInt(),
            (imgHeight * pointValue).toInt() + cardBorderOffset.toInt()
        )
    }

    private fun prepareCardArea(widthSize: Float, heightSize: Float) {
        cardArea = Rect(0, 0, widthSize.toInt(), heightSize.toInt())
        tmpRectF = RectF(cardArea)
        cardCorners = (widthSize / (cardWidth)) * 20
    }

    private fun getTextHeight(text: String, paint: TextPaint): Int {
        val tmpRect = Rect()
        paint.getTextBounds(text, 0, text.length, tmpRect)
        return tmpRect.height()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Timber.d("onLayout")
    }


    override fun onDraw(canvas: Canvas?) {
        drawCardWithoutText(canvas)
        drawTextElement(cardNameTextPoint.x, cardNameTextPoint.y, cardNameLayout, canvas)
        drawTextElement(shortDescriptionTextPoint.x, shortDescriptionTextPoint.y, shortDescriptionLayout, canvas)
        drawTextElement(
            specAbilityDescriptionTextPoint.x,
            specAbilityDescriptionTextPoint.y,
            specAbilityDescriptionLayout,
            canvas
        )
        drawCardStats(canvas)
    }

    private fun drawCardStats(canvas: Canvas?) {
        cardStatsValuePaint.color = resources.getColor(R.color.colorRockPowerValue)
        drawTextElement(rockPowerTextPoint.x, rockPowerTextPoint.y, rockPowerTextLayout, canvas)
        drawTextElement(rockPowerValuePoint.x, rockPowerValuePoint.y, rockPowerValueLayout, canvas)
        cardStatsValuePaint.color = resources.getColor(R.color.colormaxAlcoholDigestibilityValue)
        drawTextElement(
            maxAlcoholDigestibilityTextPoint.x,
            maxAlcoholDigestibilityTextPoint.y,
            maxAlcoholDigestibilityTextLayout,
            canvas
        )
        drawTextElement(
            maxAlcoholDigestibilityValuePoint.x,
            maxAlcoholDigestibilityValuePoint.y,
            maxAlcoholDigestibilityValueLayout,
            canvas
        )
        cardStatsValuePaint.color = resources.getColor(R.color.coloracousticBrainProtectionValue)
        drawTextElement(
            acousticBrainProtectionTextPoint.x,
            acousticBrainProtectionTextPoint.y,
            acousticBrainProtectionTextLayout,
            canvas
        )
        drawTextElement(
            acousticBrainProtectionValuePoint.x,
            acousticBrainProtectionValuePoint.y,
            acousticBrainProtectionValueLayout,
            canvas
        )
    }

    private fun drawTextElement(textX: Float, textY: Float, layout: StaticLayout, canvas: Canvas?) {
        canvas?.let {
            it.save()
            it.translate(textX, textY)
            layout.draw(canvas)
            it.restore()
        }
    }

    private fun drawCardWithoutText(canvas: Canvas?) {
        canvas?.let {
            it.drawRoundRect(tmpRectF, cardCorners, cardCorners, cardPaint)
            it.drawBitmap(cardImageBitmap, null, pictureArea, null)
            it.drawRect(descriptionArea, descriptionBacgroundPaint)
            it.drawBitmap(descriptionBackgroundBitmap, null, descriptionArea, null)
            it.drawRect(pictureArea, contentPaint)
        }


        /*
    canvas?.drawRect(cardNameTextArea, contentPaint)
    canvas?.drawRect(specAbilityDescriptionArea, contentPaint)
    Log.d(
        "prepareAreas",
        "specAbilityDescriptionArea = $specAbilityDescriptionArea, specAbilityDescriptionArea = $specAbilityDescriptionArea"
    )
    canvas?.drawRect(rockPowerTextArea, contentPaint)
    canvas?.drawRect(rockPowerValueArea, contentPaint)
    Log.d("prepareAreas", "rockPowerTextArea = $rockPowerTextArea, rockPowerValueArea = $rockPowerValueArea")
    canvas?.drawRect(maxAlcoholDigestibilityTextArea, contentPaint)
    canvas?.drawRect(maxAlcoholDigestibilityValueArea, contentPaint)
    canvas?.drawRect(acousticBrainProtectionTextArea, contentPaint)
    canvas?.drawRect(acousticBrainProtectionValueArea, contentPaint)
*/
    }
}