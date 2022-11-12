import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task3Test {

    Task3 task;

    @BeforeEach
    void setUp() {
        task = new Task3();
    }

    @Test
    void sortByVolume() {
        Shape shape1 = new Cube(1.0); //vol = 1
        Shape shape2 = new Cube(3.0); //vol = 27
        Shape shape3 = new Sphere(1.0); //vol = 4.188
        Shape shape4 = new Sphere(3.0); //vol = 12.566
        Shape shape5 = new Cylinder(1.0, 1.0); //vol = 3.14
        Shape shape6 = new Cylinder(3.0, 3.0); //vol = 84.8
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        shapes.add(shape4);
        shapes.add(shape5);
        shapes.add(shape6);
        task.sortByVolume(shapes);

        assertIterableEquals(List.of(shape1, shape5, shape3, shape4, shape2, shape6), shapes);
    }

    @Test
    void nullParameterShouldThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> task.sortByVolume(null));
        assertEquals("Parameter must be not null", exception.getMessage());
    }
}