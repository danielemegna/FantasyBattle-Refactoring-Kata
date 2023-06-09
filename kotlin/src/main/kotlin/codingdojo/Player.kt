package codingdojo

import kotlin.math.max
import kotlin.math.roundToInt

class Player(private val equipment: Equipment, private val stats: Stats) : Target() {

    fun calculateDamage(other: Target): Damage {
        val equipmentBaseDamage = equipment.baseDamage()
        val strengthModifier = stats.strength * 0.1f
        val damageModifier = equipment.damageModifier(strengthModifier)
        val totalDamage = (equipmentBaseDamage * damageModifier).roundToInt()
        val soak = getSoak(other, totalDamage)
        return Damage(max(0, totalDamage - soak))
    }

    private fun getSoak(other: Target, totalDamage: Int): Int {
        var soak = 0
        if (other is Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage
        } else if (other is SimpleEnemy) {
            val simpleEnemy = other
            soak = (simpleEnemy.armor.damageSoak *
                (simpleEnemy.buffs
                    .stream()
                    .mapToDouble { it.soakModifier().toDouble() }
                    .sum()) + 1f
                ).roundToInt()
        }
        return soak
    }
}
