package codingdojo;

import static codingdojo.PlayerBuilder.*;
import static codingdojo.SimpleEnemyBuilder.defaultEnemy;

public enum ProvidedEnemyVersusDifferentPlayers implements TestCase {

    PLAYER_WITH_BETTER_STATS(aPlayer().withStatsStrength(10), 122),
    PLAYER_WITH_GREAT_STATS(aPlayer().withStatsStrength(100), 302),
    PLAYER_WITH_INCREDIBLE_STATS(aPlayer().withStatsStrength(9999), 20100),

    PLAYER_WITH_WEAKER_SWORD(aPlayer().withLeftHand(ROUND_SHIELD).withRightHand(FLASHY_SWORD_OF_DANGER), 41),
    PLAYER_WITH_TWO_SWORDS(aPlayer().withLeftHand(FLASHY_SWORD_OF_DANGER).withRightHand(EXCALIBUR_SWORD), 146),
    PLAYER_WITH_TWO_EXCALIBUR_SWORDS(aPlayer().withLeftHand(EXCALIBUR_SWORD).withRightHand(EXCALIBUR_SWORD), 218),
    PLAYER_WITH_TWO_WEAKER_SWORD(aPlayer().withLeftHand(FLASHY_SWORD_OF_DANGER).withRightHand(FLASHY_SWORD_OF_DANGER), 84),
    PLAYER_WITH_TWO_ROUND_SHIELD_CAUSE_NO_DAMAGE(aPlayer().withLeftHand(ROUND_SHIELD).withRightHand(ROUND_SHIELD), 0),

    PLAYER_WITH_TWO_SWORDS_AND_BETTER_STATS(
        aPlayer()
            .withStatsStrength(10)
            .withLeftHand(FLASHY_SWORD_OF_DANGER)
            .withRightHand(EXCALIBUR_SWORD),
        176),
    PLAYER_WITH_FIVE_EXCALIBUR(
        aPlayer()
            .withLeftHand(EXCALIBUR_SWORD).withRightHand(EXCALIBUR_SWORD)
            .withHead(EXCALIBUR_SWORD).withFeet(EXCALIBUR_SWORD).withChest(EXCALIBUR_SWORD),
        740),
    PLAYER_WITH_FIVE_WEAKER_SWORD(
        aPlayer()
            .withLeftHand(FLASHY_SWORD_OF_DANGER).withRightHand(FLASHY_SWORD_OF_DANGER)
            .withHead(FLASHY_SWORD_OF_DANGER).withFeet(FLASHY_SWORD_OF_DANGER).withChest(FLASHY_SWORD_OF_DANGER),
        240),
    PLAYER_WITH_FIVE_EXCALIBUR_AND_GREAT_STATS(
        aPlayer()
            .withStatsStrength(100)
            .withLeftHand(EXCALIBUR_SWORD).withRightHand(EXCALIBUR_SWORD)
            .withHead(EXCALIBUR_SWORD).withFeet(EXCALIBUR_SWORD).withChest(EXCALIBUR_SWORD),
        1740),

    ;

    private final Player player;
    private final int expectedDamage;

    ProvidedEnemyVersusDifferentPlayers(PlayerBuilder player, int expectedDamage) {
        this.player = player.build();
        this.expectedDamage = expectedDamage;
    }

    public Player player() {
        return this.player;
    }

    public Target enemy() {
        // this test cases always use the unchanged enemy provided as example
        return defaultEnemy();
    }

    public int expectedDamage() {
        return this.expectedDamage;
    }

}
