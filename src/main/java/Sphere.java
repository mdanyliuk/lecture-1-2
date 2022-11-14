public class Sphere extends Shape {

    private final double r;

    public Sphere(double r) {
        this.r = r;
    }

    @Override
    double getVolume() {
        return Math.PI * 4 * r / 3;
    }
}
