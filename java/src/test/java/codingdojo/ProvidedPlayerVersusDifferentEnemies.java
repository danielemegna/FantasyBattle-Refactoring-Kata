package codingdojo;

import static codingdojo.PlayerBuilder.excaliburDefaultPlayer;
import static codingdojo.SimpleEnemyBuilder.anEnemy;

public enum ProvidedPlayerVersusDifferentEnemies implements TestCase {

    ENEMY_WITH_BETTER_ARMOR(anEnemy().withArmorSoak(8), 96),
    ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE(anEnemy().withArmorSoak(100), 0),
    ENEMY_WITH_ZERO_ARMOR(anEnemy().withArmorSoak(0), 112),
    ENEMY_WITH_ZERO_ARMOR_WITHOUT_BUFFS(anEnemy().withArmorSoak(0).withoutBuffs(), 112),
    ENEMY_WITH_ZERO_ARMOR_BUFFS_ARE_IGNORED(
        anEnemy()
            .withArmorSoak(0)
            .withBuffs(
                new BasicBuff(1.0f, 1.0f), new BasicBuff(2.3f, 1.0f),
                new BasicBuff(3.7f, 1.0f), new BasicBuff(2.4f, 1.0f),
                new BasicBuff(3.3f, 1.3f), new BasicBuff(4.1f, 0.0f)
            ),
        112 // like without buffs
    ),

    ENEMY_WITHOUT_BUFFS(anEnemy().withoutBuffs(), 107),
    ENEMY_WITH_SINGLE_ZERO_BUFF(anEnemy().withBuffs(new BasicBuff(0, 0)), 107), // like without buffs
    ENEMY_WITH_SINGLE_BUFF_WITH_ZERO_SOAK_AND_GREAT_DAMAGE(anEnemy().withBuffs(new BasicBuff(0, 100)), 107), // like without buffs
    ENEMY_WITH_SINGLE_GOOD_BUFF(anEnemy().withBuffs(new BasicBuff(10, 10)), 57),
    ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE(anEnemy().withBuffs(new BasicBuff(100, 0)), 0),
    ENEMY_WITH_MANY_BUFFS_REDUCE_DAMAGE(
        anEnemy().withBuffs(
            new BasicBuff(1.0f, 1.0f), new BasicBuff(2.3f, 1.0f),
            new BasicBuff(1.3f, 1.3f), new BasicBuff(1.1f, 2.1f),
            new BasicBuff(3.7f, 1.0f), new BasicBuff(2.4f, 1.0f)
        ),
        48
    ),
    ENEMY_WITH_ENOUGH_BUFFS_CAUSE_NO_DAMAGE(
        anEnemy().withBuffs(
            new BasicBuff(1.0f, 1.0f), new BasicBuff(2.3f, 1.0f),
            new BasicBuff(1.3f, 1.3f), new BasicBuff(1.1f, 2.1f),
            new BasicBuff(3.7f, 1.0f), new BasicBuff(2.4f, 1.0f),
            new BasicBuff(5.8f, 0.0f), new BasicBuff(4.1f, 2.1f)
        ),
        0
    ),

    ;

    private final Target enemy;
    private final int expectedDamage;

    ProvidedPlayerVersusDifferentEnemies(SimpleEnemyBuilder enemy, int expectedDamage) {
        this.enemy = enemy.build();
        this.expectedDamage = expectedDamage;
    }

    public Player player() {
        // this test cases always use the unchanged player provided as example
        return excaliburDefaultPlayer();
    }

    public Target enemy() {
        return this.enemy;
    }

    public int expectedDamage() {
        return this.expectedDamage;
    }

}
