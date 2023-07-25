package codingdojo;

import static codingdojo.PlayerBuilder.aPlayer;
import static codingdojo.SimpleEnemyBuilder.anEnemy;

public enum ProvidedEnemyWithDifferentPlayersTestCases implements TestCase {

    PLAYER_WITH_BETTER_STATS(aPlayer().withStatsStrength(10), 122),
    PLAYER_WITH_GREAT_STATS(aPlayer().withStatsStrength(100), 302),
    PLAYER_WITH_INCREDIBLE_STATS(aPlayer().withStatsStrength(9999), 20100);

    private final Player player;
    private final int expectedDamage;

    ProvidedEnemyWithDifferentPlayersTestCases(PlayerBuilder player, int expectedDamage) {
        this.player = player.build();
        this.expectedDamage = expectedDamage;
    }

    public Player player() {
        return this.player;
    }

    public Target enemy() {
        // this test cases always use the unchanged enemy provided as example
        return anEnemy().build();
    }

    public int expectedDamage() {
        return this.expectedDamage;
    }

}
