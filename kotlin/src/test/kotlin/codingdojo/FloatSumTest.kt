package codingdojo

import org.junit.Assert.assertNotEquals
import org.junit.Test
import kotlin.test.assertEquals

class FloatSumTest {

    @Test
    fun twoNumbersWithFloat() {
        val sum = 0.1f + 0.2f
        assertEquals(0.3f, sum)
    }

    @Test
    fun twoNumbersWithDouble() {
        val sum = 0.1 + 0.2
        // Sum TILT ! - floating-point-gui.de
        assertNotEquals(0.3, sum)
    }

    @Test
    fun fourNumbersWithFloat() {
        val sum = 0.1f + 1.5f + 0.3f
        // Sum TILT ! - floating-point-gui.de
        assertNotEquals(1.9f, sum)
    }

    @Test
    fun fourNumbersWithDouble() {
        val sum = 0.1 + 0.5 + 1.5 + 0.3
        assertEquals(2.4, sum)
    }

    @Test
    fun twoVeryProblematicNumbersWithFloat() {
        val sum = 1.6f + 0.3f
        // Sum TILT ! - floating-point-gui.de
        assertNotEquals(1.9f, sum)
    }

    @Test
    fun twoVeryProblematicNumbersWithDouble() {
        val sum = 1.6 + 0.3
        // Sum TILT ! - floating-point-gui.de
        assertNotEquals(1.9, sum)
    }

    @Test
    fun twoNumbersWithoutProblemWithFloat() {
        val sum = 0.1f + 0.4f
        assertEquals(0.5f, sum)
    }

    @Test
    fun twoNumbersWithoutProblemWithDouble() {
        val sum = 0.1 + 0.4
        assertEquals(0.5, sum)
    }

}