import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Shape {
    abstract double getVolume();
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
