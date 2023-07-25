package codingdojo;

import static codingdojo.PlayerBuilder.aPlayer;
import static codingdojo.SimpleEnemyBuilder.anEnemy;

public enum TestCase {

    PROVIDED_EXAMPLE(aPlayer(), anEnemy(), 102),
    ENEMY_WITH_BETTER_ARMOR(
        aPlayer(),
        anEnemy().withArmorSoak(8),
        96
    ),
    ENEMY_WITHOUT_BUFFS(
        aPlayer(),
        anEnemy().withoutBuffs(),
        107
    );

    private final Player player;
    private final Target enemy;
    private final int expectedDamage;

    TestCase(PlayerBuilder player, SimpleEnemyBuilder enemy, int expectedDamage) {
        this.player = player.build();
        this.enemy = enemy.build();
        this.expectedDamage = expectedDamage;
    }

    public Player player() {
        return this.player;
    }

    public Target enemy() {
        return this.enemy;
    }

    public int expectedDamage() {
        return this.expectedDamage;
    }

}
