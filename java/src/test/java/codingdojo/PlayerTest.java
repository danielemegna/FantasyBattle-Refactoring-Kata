package codingdojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static codingdojo.PlayerBuilder.aPlayer;
import static codingdojo.SimpleEnemyBuilder.anEnemy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void damageForProvidedExample() {
        Player player = aPlayer().build();
        Target enemy = anEnemy().build();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(102, damage.getAmount());
    }

    @ParameterizedTest
    @EnumSource(ProvidedPlayerWithDifferentEnemiesTestCases.class)
    void providedPlayerWithDifferentEnemies(TestCase testCase) {
        Player player = testCase.player();
        Target enemy = testCase.enemy();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(testCase.expectedDamage(), damage.getAmount());
    }

    @ParameterizedTest
    @EnumSource(ProvidedEnemyWithDifferentPlayersTestCases.class)
    void providedEnemyWithDifferentPlayers(TestCase testCase) {
        Player player = testCase.player();
        Target enemy = testCase.enemy();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(testCase.expectedDamage(), damage.getAmount());
    }

    @Test
    void providedPlayerVersusProvidedPlayer() {
        Player player = aPlayer().build();
        Target enemy = aPlayer().build();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(0, damage.getAmount());
    }

}
