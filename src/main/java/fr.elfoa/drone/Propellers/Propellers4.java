package fr.elfoa.drone.Propellers;

import fr.elfoa.drone.Annotations.BatteryType;
import fr.elfoa.drone.Annotations.ModuleType;
import fr.elfoa.drone.Annotations.PropellersNumber;
import fr.elfoa.drone.Annotations.PropellersType;
import fr.elfoa.drone.Battery.Battery;
import fr.elfoa.drone.ConsumptionCalculator;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@PropellersType(PropellersNumber.FOUR)
@Entity
public class Propellers4 implements IPropellers{

    @Column
    private Integer number = 4;

    @Inject
    @BatteryType(ModuleType.STANDARD)
    @ManyToOne
    private Battery battery;

    @Inject
    @OneToOne(mappedBy = "propellers")
    private ConsumptionCalculator calculator;

    @Column
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
