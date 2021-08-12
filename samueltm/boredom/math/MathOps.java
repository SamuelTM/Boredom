package samueltm.boredom.math;

import java.util.ArrayList;

public class MathOps {

    public static double nthRoot(double base, double root) {
        return Math.pow(base, 1.0 / root);
    }

    public static double arithmeticMean(double[] numbers) {
        double sum = 0;
        for(double n : numbers)
            sum += n;
        return sum / numbers.length;
    }

    public static double geometricMean(double[] numbers) {
        double product = 1;
        for (double n : numbers) {
            if (n > 0) {
                product *= n;
            } else {
                throw new IllegalArgumentException("Can't calculate the geometric mean of non-positive numbers");
            }
        }
        return nthRoot(product, numbers.length);
    }

    public static double dotProduct(double[] a, double[] b) {
        if (a.length == b.length) {
            double sum = 0;
            for(int i = 0; i < a.length; i++) {
                sum += a[i] * b[i];
            }

            return sum;
        } else {
            throw new IllegalArgumentException("Both arrays must be of the same size");
        }
    }

    public static ArrayList<Integer> factors(int n) {
        final ArrayList<Integer> factors = new ArrayList<>();
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    factors.add(i);
                }
            }
        } else {
            for(int i = n; i <= Math.abs(n); i++) {
                if (i != 0 && n % i == 0) {
                    factors.add(i);
                }
            }
        }
        return factors;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static int gcd(int... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }
        return result;
    }

    public static int lcm(int... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = lcm(result, numbers[i]);
        }
        return result;
    }

}
