package samueltm.boredom.math.geometry.shapes;

import samueltm.mymess.math.geometry.Shape;

public class Cube extends Shape {

    private final double sidesLength;

    public Cube(double sidesLength) {
        this.sidesLength = sidesLength;
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(sidesLength, 2);
    }
}
