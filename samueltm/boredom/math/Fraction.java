package samueltm.boredom.math;

import java.util.Objects;

public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Can't have a fraction with a zero denominator");
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction sum(Fraction b) {
        if (denominator == b.denominator) {
            return new Fraction(numerator + b.numerator, denominator);
        } else {
            final int lcm = MathOps.lcm(denominator, b.denominator);
            final Fraction newA = new Fraction(lcm / denominator * numerator, lcm);
            final Fraction newB = new Fraction(lcm / b.denominator * b.numerator, lcm);
            return newA.sum(newB);
        }
    }

    public Fraction subtract(Fraction b) {
        if (denominator == b.denominator) {
            return new Fraction(numerator - b.numerator, denominator);
        } else {
            final int lcm = MathOps.lcm(denominator, b.denominator);
            final Fraction newA = new Fraction(lcm / denominator * numerator, lcm);
            final Fraction newB = new Fraction(lcm / b.denominator * b.numerator, lcm);
            return newA.subtract(newB);
        }
    }

    public Fraction multiply(Fraction b) {
        return new Fraction(numerator * b.numerator, denominator * b.denominator);
    }

    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    public Fraction divide(Fraction b) {
        return multiply(b.invert());
    }

    public Fraction simplify() {
        final int gcd = MathOps.gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
