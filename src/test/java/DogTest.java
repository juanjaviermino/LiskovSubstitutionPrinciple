import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DogTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirige la salida estándar a outContent para capturar la salida
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testMakeSound() {
        Animal dog = new Dog();
        dog.makeSound();
        String output = outContent.toString().trim();
        assertEquals("Dog barks.", output, "Se esperaba el sonido del perro: 'Dog barks.'");
    }

    @Test
    void testWalk() {
        outContent.reset();
        Animal dog = new Dog();
        assertTrue(dog instanceof WalkingAnimal, "Dog debería implementar WalkingAnimal.");

        ((WalkingAnimal) dog).walk();
        String output = outContent.toString().trim();
        assertEquals("Dog is walking.", output, "Se esperaba que el perro caminara: 'Dog is walking.'");
    }
}
