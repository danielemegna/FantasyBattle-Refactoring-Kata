package codingdojo

open class Stats(
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    private val strength: Int
) {
    fun strengthModifier(): Float {
        return strength * 0.1f
    }
}
