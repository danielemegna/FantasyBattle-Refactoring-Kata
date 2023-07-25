package codingdojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @ParameterizedTest
    @EnumSource(TestCase.class)
    void providedPlayerWithSeveralEnemies(TestCase testCase) {
        Player player = testCase.player();
        Target enemy = testCase.enemy();
        Damage damage = player.calculateDamage(enemy);
        assertEquals(testCase.expectedDamage(), damage.getAmount());
    }

}
