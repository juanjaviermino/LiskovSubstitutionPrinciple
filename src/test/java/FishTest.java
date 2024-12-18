import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class FishTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testMakeSound() {
        Animal fish = new Fish();
        fish.makeSound();
        String output = outContent.toString().trim();
        assertEquals("Fish makes bubbles.", output, "Se esperaba el sonido del pez: 'Fish makes bubbles.'");
    }

    @Test
    void testNotWalkingAnimal() {
        Animal fish = new Fish();
        assertFalse(fish instanceof WalkingAnimal, "Fish no debería implementar WalkingAnimal.");
    }
}
