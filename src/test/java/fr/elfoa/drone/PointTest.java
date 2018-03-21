package fr.elfoa.drone;

import fr.elfoa.AbstractBootstraper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest extends AbstractBootstraper{

    @BeforeClass
    public static void start()
    {
        init();
    }

    @AfterClass
    public static void stop()
    {
        shutdown();
    }


    @Test
    public void distancePoint(){
        Point Origine = getInstance(Point.class);

        Point p = new Point(0d, 0d, 1d);

        assertEquals(1d, p.distanceTo(Origine), 0);

    }
}
