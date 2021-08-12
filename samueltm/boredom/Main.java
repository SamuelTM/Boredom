package samueltm.boredom;

import samueltm.boredom.math.linalg.Matrix2D;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static Matrix2D generateMatrix(int nRows, int nColumns) {
        final double[] numbers = new double[nRows * nColumns];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt(-10, 11);
        }
        return new Matrix2D(numbers, nRows, nColumns);
    }

    public static void main(String[] args) {
        Matrix2D a = generateMatrix(1000, 1000);
        Matrix2D b = generateMatrix(1000, 1000);
        long startTime = System.nanoTime();
        a.multiply(b);
        long totalTime = (long) ((System.nanoTime() - startTime) / 1e6);
        System.out.println("Total time: " + totalTime + "ms");
    }
}
