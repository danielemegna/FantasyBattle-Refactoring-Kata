package codingdojo

class Equipment(
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    val leftHand: Item,
    val rightHand: Item,
    val head: Item,
    val feet: Item,
    val chest: Item
) {
    fun baseDamage(): Int {
        return leftHand.baseDamage +
            rightHand.baseDamage +
            head.baseDamage +
            feet.baseDamage +
            chest.baseDamage
    }

    fun damageModifier(strengthModifier: Float): Float {
        return strengthModifier +
            leftHand.damageModifier +
            rightHand.damageModifier +
            head.damageModifier +
            feet.damageModifier +
            chest.damageModifier

    }
}
