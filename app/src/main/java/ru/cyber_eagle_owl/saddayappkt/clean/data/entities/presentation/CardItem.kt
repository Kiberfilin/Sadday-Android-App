package ru.cyber_eagle_owl.saddayappkt.clean.data.entities.presentation

data class CardItem(
    var cardImages: List<Int>,
    var cardStrings: Array<String>,
    var rockPowerValue: Int,
    var maxAlcoholDigestibilityValue: Int,
    var acousticBrainProtectionValue: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardItem

        if (cardImages != other.cardImages) return false
        if (!cardStrings.contentEquals(other.cardStrings)) return false
        if (rockPowerValue != other.rockPowerValue) return false
        if (maxAlcoholDigestibilityValue != other.maxAlcoholDigestibilityValue) return false
        if (acousticBrainProtectionValue != other.acousticBrainProtectionValue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cardImages.hashCode()
        result = 31 * result + cardStrings.contentHashCode()
        result = 31 * result + rockPowerValue
        result = 31 * result + maxAlcoholDigestibilityValue
        result = 31 * result + acousticBrainProtectionValue
        return result
    }
}