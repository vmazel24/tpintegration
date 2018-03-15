package fr.elfoa.drone;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    private static final Point ORIGIN = new Point(0d,0d,0d);

    @Test
    public void distancePoint(){

        Point p = new Point(0d, 0d, 1d);

        assertEquals(1d, p.distanceTo(ORIGIN), 0);

    }
}
