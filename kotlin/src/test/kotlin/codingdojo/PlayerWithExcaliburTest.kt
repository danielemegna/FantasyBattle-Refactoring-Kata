package codingdojo

import org.junit.Test
import kotlin.test.assertEquals

class PlayerWithExcaliburTest {

    private val excaliburEquipment = Equipment(
        leftHand = BasicItem(name = "round shield", baseDamage = 0, damageModifier = 1.4f),
        rightHand = BasicItem(name = "excalibur", baseDamage = 20, damageModifier = 1.5f),
        head = BasicItem(name = "helmet of swiftness", baseDamage = 0, damageModifier = 1.2f),
        feet = BasicItem(name = "ten league boots", baseDamage = 0, damageModifier = 0.1f),
        chest = BasicItem(name = "breastplate of steel", baseDamage = 0, damageModifier = 1.4f),
    )

    @Test
    fun `Player attack an enemy without buffs`() {
        assertEquals(
            expected = 131,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(1),
                enemyBuffs = emptyList()
            )
        )
    }

    @Test
    fun `Armor is ignored with no buffs`() {
        assertEquals(
            expected = 131,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(9999),
                enemyBuffs = emptyList()
            )
        )
    }

    @Test
    fun `Enemy with basic buff reduce damages`() {
        assertEquals(
            expected = 121,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(10),
                enemyBuffs = listOf<Buff>(
                    BasicBuff(soak = 1.0f, damage = 1.0f)
                )
            )
        )
    }

    @Test
    fun `Buff soak multiply the armor soak value`() {
        assertEquals(
            expected = 101,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(10),
                enemyBuffs = listOf<Buff>(
                    BasicBuff(soak = 3.0f, damage = 1.0f)
                )
            )
        )
    }

    @Test
    fun `Buff damage value is ignored`() {
        assertEquals(
            expected = 121,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(10),
                enemyBuffs = listOf<Buff>(
                    BasicBuff(soak = 1.0f, damage = 9999.0f)
                )
            )
        )
    }

    @Test
    fun `Damage is higher with strong stats`() {
        assertEquals(
            expected = 301,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(100),
                enemyArmor = SimpleArmor(10),
                enemyBuffs = listOf<Buff>(
                    BasicBuff(soak = 1.0f, damage = 1.0f)
                )
            )
        )
    }

    @Test
    fun `Enemy with multiple buffs takes less damage coherently`() {
        assertEquals(
            expected = 88,
            actual = damageWith(
                playerEquipment = excaliburEquipment,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(10),
                enemyBuffs = listOf<Buff>(
                    BasicBuff(soak = 1.0f, damage = 1.0f),
                    BasicBuff(soak = 2.0f, damage = 1.0f),
                    BasicBuff(soak = 1.3f, damage = 1.0f)
                )
            )
        )
    }

    private fun damageWith(
        playerEquipment: Equipment,
        playerStats: Stats,
        enemyArmor: SimpleArmor,
        enemyBuffs: List<Buff>
    ): Int {
        val target = SimpleEnemy(enemyArmor, enemyBuffs)
        val player = Player(playerEquipment, playerStats)
        return player.calculateDamage(target).amount
    }

}
