package codingdojo;

import static codingdojo.ProvidedEnemyWithDifferentPlayers.*;
import static codingdojo.ProvidedPlayerWithDifferentEnemies.*;

public enum CombinedCustomPlayersWithCustomEnemies implements TestCase {

    BETTER_STATS_VS_BETTER_ARMOR(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_BETTER_ARMOR, 116),
    BETTER_STATS_VS_GREAT_ARMOR(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE, 0),
    BETTER_STATS_VS_ZERO_ARMOR(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_ZERO_ARMOR, 132),
    BETTER_STATS_VS_SINGLE_BUFF(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_SINGLE_GOOD_BUFF, 77),
    BETTER_STATS_VS_SINGLE_GREAT_BUFF(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE, 0),
    BETTER_STATS_VS_MANY_BUFFS(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_MANY_BUFFS_REDUCE_DAMAGE, 68),
    BETTER_STATS_VS_MORE_BUFFS(PLAYER_WITH_BETTER_STATS, ENEMY_WITH_ENOUGH_BUFFS_CAUSE_NO_DAMAGE, 18),

    WEAK_SWORD_VS_BETTER_ARMOR(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_BETTER_ARMOR, 35),
    WEAK_SWORD_VS_GREAT_ARMOR(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE, 0),
    WEAK_SWORD_VS_ZERO_ARMOR(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_ZERO_ARMOR, 51),
    WEAK_SWORD_VS_SINGLE_BUFF(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_SINGLE_GOOD_BUFF, 0),
    WEAK_SWORD_VS_SINGLE_GREAT_BUFF(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE, 0),
    WEAK_SWORD_VS_MANY_BUFFS(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_MANY_BUFFS_REDUCE_DAMAGE, 0),
    WEAK_SWORD_VS_MORE_BUFFS(PLAYER_WITH_WEAKER_SWORD, ENEMY_WITH_ENOUGH_BUFFS_CAUSE_NO_DAMAGE, 0),

    TWO_SWORDS_VS_BETTER_ARMOR(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_BETTER_ARMOR, 140),
    TWO_SWORDS_VS_GREAT_ARMOR(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE, 0),
    TWO_SWORDS_VS_ZERO_ARMOR(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_ZERO_ARMOR, 156),
    TWO_SWORDS_VS_SINGLE_BUFF(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_SINGLE_GOOD_BUFF, 101),
    TWO_SWORDS_VS_SINGLE_GREAT_BUFF(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE, 0),
    TWO_SWORDS_VS_MANY_BUFFS(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_MANY_BUFFS_REDUCE_DAMAGE, 92),
    TWO_SWORDS_VS_MORE_BUFFS(PLAYER_WITH_TWO_SWORDS, ENEMY_WITH_ENOUGH_BUFFS_CAUSE_NO_DAMAGE, 42),

    TWO_EXCALIBUR_VS_BETTER_ARMOR(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_BETTER_ARMOR, 212),
    TWO_EXCALIBUR_VS_GREAT_ARMOR(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE, 28),
    TWO_EXCALIBUR_VS_ZERO_ARMOR(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_ZERO_ARMOR, 228),
    TWO_EXCALIBUR_VS_SINGLE_BUFF(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_SINGLE_GOOD_BUFF, 173),
    TWO_EXCALIBUR_VS_SINGLE_GREAT_BUFF(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE, 0),
    TWO_EXCALIBUR_VS_MANY_BUFFS(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_MANY_BUFFS_REDUCE_DAMAGE, 164),
    TWO_EXCALIBUR_VS_MORE_BUFFS(PLAYER_WITH_TWO_EXCALIBUR_SWORDS, ENEMY_WITH_ENOUGH_BUFFS_CAUSE_NO_DAMAGE, 114),

    FIVE_EXCALIBUR_VS_BETTER_ARMOR(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_BETTER_ARMOR, 734),
    FIVE_EXCALIBUR_VS_GREAT_ARMOR(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_GREAT_ARMOR_CAUSE_NO_DAMAGE, 550),
    FIVE_EXCALIBUR_VS_ZERO_ARMOR(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_ZERO_ARMOR, 750),
    FIVE_EXCALIBUR_VS_SINGLE_BUFF(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_SINGLE_GOOD_BUFF, 695),
    FIVE_EXCALIBUR_VS_SINGLE_GREAT_BUFF(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_SINGLE_BUFF_WITH_GREAT_SOAK_CAUSE_NO_DAMAGE, 245),
    FIVE_EXCALIBUR_VS_MANY_BUFFS(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_MANY_BUFFS_REDUCE_DAMAGE, 686),
    FIVE_EXCALIBUR_VS_MORE_BUFFS(PLAYER_WITH_FIVE_EXCALIBUR, ENEMY_WITH_ENOUGH_BUFFS_CAUSE_NO_DAMAGE, 636),

    ;

    private final Player player;
    private final Target enemy;
    private final int expectedDamage;

    CombinedCustomPlayersWithCustomEnemies(TestCase playerTestCase, TestCase enemyTestCase, int expectedDamage) {
        this.player = playerTestCase.player();
        this.enemy = enemyTestCase.enemy();
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
