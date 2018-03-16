package fr.elfoa.drone;

import static org.junit.Assert.assertEquals;

import fr.elfoa.AbstractBootstraper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Pierre Colomb
 */
public class DroneTest  extends AbstractBootstraper
{
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
    public void tackOff() throws Exception {

        Drone drone = getInstance(Drone.class);
        drone.tackOff();
        assertEquals(50d, drone.getCurrentPosition().getAltitude(), 0);
        assertEquals(50d, drone.getCurrentPosition().getAltitude(), 0);
    }


    @Test
    public void flyTo() throws Exception
    {
        Drone drone = getInstance(Drone.class);
        drone.tackOff();
        drone.flyTo(new Point(55d, 32.5d, 12.1d));

        assertEquals(55d, drone.getCurrentPosition().getLatitude(), 0);
        assertEquals(32.5d, drone.getCurrentPosition().getLongitude(), 0);
        assertEquals(12.1d, drone.getCurrentPosition().getAltitude(), 0);
    }

    @Test
    public void landing() throws Exception
    {
        Drone drone = getInstance(Drone.class);
        drone.tackOff();
        drone.flyTo(new Point(55d, 32.5d, 12.1d));
        drone.landing();

        assertEquals(55d, drone.getCurrentPosition().getLatitude(), 0);
        assertEquals(32.5d, drone.getCurrentPosition().getLongitude(), 0);
        assertEquals(0d, drone.getCurrentPosition().getAltitude(), 0);
    }

    @Test
    public void isCanFly() throws Exception
    {
        Drone drone = getInstance(Drone.class);
        assertEquals(true, drone.isCanFly());
    }

    @Test
    public void getCurrentPosition() throws Exception
    {
        Drone drone = getInstance(Drone.class);
        drone.tackOff();
        drone.flyTo(new Point(55d, 32.5d, 12.1d));
        Point expected = new Point(55d, 32.5d, 12.1d);

        assertEquals(expected, drone.getCurrentPosition());
    }

}