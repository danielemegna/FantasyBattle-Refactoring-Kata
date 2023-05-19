package codingdojo

import org.junit.Test
import kotlin.test.assertEquals

class PlayerTest {

    private val anInventory = Inventory(
        Equipment(
            leftHand = BasicItem(name = "round shield", baseDamage = 0, damageModifier = 1.4f),
            rightHand = BasicItem(name = "excalibur", baseDamage = 20, damageModifier = 1.5f),
            head = BasicItem(name = "helmet of swiftness", baseDamage = 0, damageModifier = 1.2f),
            feet = BasicItem(name = "ten league boots", baseDamage = 0, damageModifier = 0.1f),
            chest = BasicItem(name = "breastplate of steel", baseDamage = 0, damageModifier = 1.4f),
        )
    )

    @Test
    fun `Player attack an enemy without buffs`() {
        assertEquals(
            expected = 131,
            actual = damageWith(
                playerInventory = anInventory,
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
                playerInventory = anInventory,
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
                playerInventory = anInventory,
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
                playerInventory = anInventory,
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
                playerInventory = anInventory,
                playerStats = Stats(10),
                enemyArmor = SimpleArmor(10),
                enemyBuffs = listOf<Buff>(
                    BasicBuff(soak = 1.0f, damage = 9999.0f)
                )
            )
        )
    }

    private fun damageWith(
        playerInventory: Inventory,
        playerStats: Stats,
        enemyArmor: SimpleArmor,
        enemyBuffs: List<Buff>
    ): Int {
        val target = SimpleEnemy(enemyArmor, enemyBuffs)
        val player = Player(playerInventory, playerStats)
        return player.calculateDamage(target).amount
    }

}
