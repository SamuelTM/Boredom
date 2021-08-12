package samueltm.boredom.math.geometry;

import java.util.Objects;

public class Segment2D {

    private final Point2D start;
    private final Point2D end;

    public Segment2D(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    public boolean contains(Point2D p) {
        final double ab = start.distance(end);
        final double ap = start.distance(p);
        final double pb = p.distance(end);
        return ab == ap + pb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Segment2D segment2D = (Segment2D) o;
        return start.equals(segment2D.start) && end.equals(segment2D.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
