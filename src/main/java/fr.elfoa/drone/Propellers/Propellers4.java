package fr.elfoa.drone.Propellers;

import fr.elfoa.drone.Annotations.PropellersNumber;
import fr.elfoa.drone.Annotations.PropellersType;
import fr.elfoa.drone.Battery.Battery;
import fr.elfoa.drone.ConsumptionCalculator;

import javax.inject.Inject;

/**
 * @author Pierre Colomb
 */
@PropellersType(PropellersNumber.FOUR)
public class Propellers4 implements IPropellers{

    private Integer number = 4;

    @Inject
    private Battery battery;

    @Inject
    private ConsumptionCalculator calculator;

    private Boolean isRunning = false;

    @Inject
    public Propellers4(){}


    public void start(){
        battery.use(calculator.getConsumption(number));
        isRunning = true;
    }

    public void stop(){
        isRunning = false;
    }

    public void setBattery(Battery battery){
        this.battery = battery;
    }

    public Integer getNumberOfPropelle() {
        return number;
    }



    public Boolean getRunning() {
        return isRunning;
    }
}
