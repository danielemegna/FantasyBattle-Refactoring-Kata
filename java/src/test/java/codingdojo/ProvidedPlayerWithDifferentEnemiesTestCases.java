package codingdojo;

import static codingdojo.PlayerBuilder.aPlayer;
import static codingdojo.SimpleEnemyBuilder.anEnemy;

public enum ProvidedPlayerWithDifferentEnemiesTestCases implements TestCase {

    ENEMY_WITH_BETTER_ARMOR(
        anEnemy().withArmorSoak(8),
        96
    ),
    ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE(
        anEnemy().withArmorSoak(100),
        0
    ),
    ENEMY_WITHOUT_BUFFS(
        anEnemy().withoutBuffs(),
        107
    ),
    ENEMY_WITH_SINGLE_ZERO_BUFF(
        anEnemy().withBuffs(new BasicBuff(0, 0)),
        107 // like without buffs
    ),
    ENEMY_WITH_SINGLE_BUFF_WITH_ZERO_SOAK_AND_GREAT_DAMAGE(
        anEnemy().withBuffs(new BasicBuff(0, 100)),
        107 // like without buffs
    ),
    ENEMY_WITH_SINGLE_BIG_BUFF(
        anEnemy().withBuffs(new BasicBuff(10, 10)),
        57
    ),
    ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE(
        anEnemy().withBuffs(new BasicBuff(100, 0)),
        0
    ),
    ENEMY_WITH_MANY_BUFFS(
        anEnemy().withBuffs(
            new BasicBuff(1, 1), new BasicBuff(2.3f, 1.0f),
            new BasicBuff(1.3f, 1.3f), new BasicBuff(1.1f, 2.1f)
        ),
        78
    );

    private final Target enemy;
    private final int expectedDamage;

    ProvidedPlayerWithDifferentEnemiesTestCases(SimpleEnemyBuilder enemy, int expectedDamage) {
        this.enemy = enemy.build();
        this.expectedDamage = expectedDamage;
    }

    public Player player() {
        // this test cases always use the unchanged player provided as example
        return aPlayer().build();
    }

    public Target enemy() {
        return this.enemy;
    }

    public int expectedDamage() {
        return this.expectedDamage;
    }

}
