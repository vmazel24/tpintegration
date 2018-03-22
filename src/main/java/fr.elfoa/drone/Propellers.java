package fr.elfoa.drone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class Propellers {

    @Column
    private Integer number = 4;

    @OneToOne(mappedBy = "propellers")
    private Battery battery;

    @OneToOne(mappedBy = "propellers")
    private ConsumptionCalculator calculator = new ConsumptionCalculator();

    @Column
    private Boolean isRunning = false;

    public Propellers(Battery battery){
        this.battery = battery;
    }

    public void start(){
        battery.use(calculator.getConsumption(number));
        isRunning = true;
    }

    public void stop(){
        isRunning = false;
    }


    public Integer getNumberOfPropelle() {
        return number;
    }



    public Boolean getRunning() {
        return isRunning;
    }
}
