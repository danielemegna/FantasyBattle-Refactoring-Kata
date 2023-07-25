package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void damageForProvidedExample() {
        Damage damage = damageWith(aPlayer(), anEnemy());
        assertEquals(102, damage.getAmount());
    }

    private static Damage damageWith(Player player, SimpleEnemy target) {
        return player.calculateDamage(target);
    }

    private static Player aPlayer() {
        Equipment equipment = anEquipment();
        return new Player(
            new Inventory(equipment),
            new Stats(0)
        );
    }

    private static SimpleEnemy anEnemy() {
        return new SimpleEnemy(
            new SimpleArmor(5),
            List.of(new BasicBuff(1.0f, 1.0f))
        );
    }

    private static Equipment anEquipment() {
        return new Equipment(
            new BasicItem("Round Shield", 0, 1.4f),
            new BasicItem("Excalibur", 20, 1.5f),
            new BasicItem("Helmet of swiftness", 0, 1.2f),
            new BasicItem("Ten league boots", 0, 0.1f),
            new BasicItem("Breastplate of steel", 0, 1.4f)

        );
    }
}
