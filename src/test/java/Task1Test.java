import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task1Test {

    Task1 task;

    @BeforeEach
    void setUp() {
        task = new Task1();
    }

    @Test
    void findPositiveNumbers() {
        assertArrayEquals(new Integer[] {10, 5, 1, 0}, task.findPositiveNumbers(new Integer[] {5, -1, 0, 10, 1, -10}));
    }

    @Test
    void nullParameterShouldThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> task.findPositiveNumbers(null));
        assertEquals("Parameter must be not null", exception.getMessage());
    }

    @Test
    void allNegativeNumbersShouldReturnEmptyArray() {
        assertArrayEquals(new Integer[] {}, task.findPositiveNumbers(new Integer[] {-5, -1, -20}));
    }
}