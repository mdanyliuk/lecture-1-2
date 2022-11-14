public class Cube extends Shape {

    private final double a;

    public Cube(double a) {
        this.a = a;
    }

    @Override
    public double getVolume() {
        return a * a * a;
    }
}
