package fr.elfoa.drone.Propellers;

import fr.elfoa.drone.Battery.Battery;
import fr.elfoa.drone.ConsumptionCalculator;

import javax.inject.Inject;

public interface IPropellers {

    Boolean isRunning = false;


    public void start();

    public void stop();

    public void setBattery(Battery battery);

    public Integer getNumberOfPropelle();

    public Boolean getRunning();
}
