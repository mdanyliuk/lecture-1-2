import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Shape {
    abstract double getVolume();
}

class Cube extends Shape {

    private final double a;

    public Cube(double a) {
        this.a = a;
    }

    @Override
    public double getVolume() {
        return a * a * a;
    }
}

class Sphere extends Shape {

    private final double r;

    public Sphere(double r) {
        this.r = r;
    }

    @Override
    double getVolume() {
        return Math.PI * 4 * r / 3;
    }
}

class Cylinder extends Shape {

    private final double r;
    private final double h;

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    double getVolume() {
        return Math.PI * r * r * h;
    }
}

public class Task3 {

    /**
     * Sorts given list of 3D shapes according their volume.
     *
     * @param shapes the list to be sorted
     */
    public void sortByVolume(List<Shape> shapes) {
        if (shapes == null) {
            throw new IllegalArgumentException("Parameter must be not null");
        }
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2) {
                return Double.compare(shape1.getVolume(), shape2.getVolume());
            }
        });
    }
}
