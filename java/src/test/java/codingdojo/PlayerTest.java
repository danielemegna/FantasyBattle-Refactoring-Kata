package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void damageForProvidedExample() {
        Equipment equipment = new Equipment(
            new BasicItem("Round Shield", 0, 1.4f),
            new BasicItem("Excalibur", 20, 1.5f),
            new BasicItem("Helmet of swiftness", 0, 1.2f),
            new BasicItem("Ten league boots", 0, 0.1f),
            new BasicItem("Breastplate of steel", 0, 1.4f)

        );
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(0);
        Player player = new Player(inventory, stats);

        Armor armor = new SimpleArmor(5);
        List<Buff> buffs = List.of(
            new BasicBuff(1.0f, 1.0f)
        );
        SimpleEnemy target = new SimpleEnemy(armor, buffs);

        Damage damage = player.calculateDamage(target);

        assertEquals(102, damage.getAmount());
    }
}
