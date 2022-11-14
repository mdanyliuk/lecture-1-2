public class Cylinder extends Shape {

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
