package fr.elfoa.drone.Battery;

import fr.elfoa.drone.Module;

public interface IBattery {

    void use(Integer power);

    Integer getPower();
}