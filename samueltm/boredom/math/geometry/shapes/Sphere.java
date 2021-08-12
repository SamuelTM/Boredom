package samueltm.boredom.math.geometry.shapes;

import samueltm.mymess.math.geometry.Shape;

public class Sphere extends Shape {

    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
