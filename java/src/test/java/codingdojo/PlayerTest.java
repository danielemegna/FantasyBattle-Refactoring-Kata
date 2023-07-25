package codingdojo;

import codingdojo.builders.SimpleEnemyBuilder;
import org.junit.jupiter.api.Test;

import static codingdojo.builders.SimpleEnemyBuilder.anEnemy;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void damageForProvidedExample() {
        Damage damage = damageWith(aPlayer(), anEnemy());
        assertEquals(102, damage.getAmount());
    }

    @Test
    void providedPlayerWithEnemyWithDifferentArmor() {
        SimpleEnemyBuilder enemy = anEnemy().withArmor(new SimpleArmor(8));
        Damage damage = damageWith(aPlayer(), enemy);
        assertEquals(96, damage.getAmount());
    }

    @Test
    void providedPlayerWithEnemyWithoutBuffs() {
        SimpleEnemyBuilder enemy = anEnemy().withBuffs(emptyList());
        Damage damage = damageWith(aPlayer(), enemy);
        assertEquals(107, damage.getAmount());
    }

    private static Damage damageWith(Player player, SimpleEnemyBuilder enemyBuilder) {
        SimpleEnemy enemy = enemyBuilder.build();
        return player.calculateDamage(enemy);
    }

    private static Player aPlayer() {
        Equipment equipment = anEquipment();
        return new Player(
            new Inventory(equipment),
            new Stats(0)
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
