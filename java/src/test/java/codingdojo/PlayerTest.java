package codingdojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static codingdojo.PlayerBuilder.excaliburDefaultPlayer;
import static codingdojo.SimpleEnemyBuilder.defaultEnemy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void damageForProvidedExample() {
        Player player = excaliburDefaultPlayer();
        Target enemy = defaultEnemy();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(102, damage.getAmount());
    }

    @ParameterizedTest
    @EnumSource(ProvidedPlayerWithDifferentEnemies.class)
    void providedPlayerWithDifferentEnemies(TestCase testCase) {
        runTestCase(testCase);
    }

    @ParameterizedTest
    @EnumSource(ProvidedEnemyWithDifferentPlayers.class)
    void providedEnemyWithDifferentPlayers(TestCase testCase) {
        runTestCase(testCase);
    }

    @Test
    void providedPlayerVersusProvidedPlayer() {
        Player player = excaliburDefaultPlayer();
        Target enemy = excaliburDefaultPlayer();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(0, damage.getAmount());
    }

    private static void runTestCase(TestCase testCase) {
        Player player = testCase.player();
        Target enemy = testCase.enemy();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(testCase.expectedDamage(), damage.getAmount());
    }


}
