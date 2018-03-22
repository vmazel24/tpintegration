package fr.elfoa.drone;

import fr.elfoa.drone.Battery.Battery;
import fr.elfoa.drone.Battery.IBattery;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class Module {

    @Column
    private Integer power;

    @ManyToOne
    private IBattery battery;

    public Module()
    {

    }

    public Module(Integer power){
        this.power = power;
    }
    
    public void use(Integer power){
        this.power -= power;
    }

    public Integer getPower() {
        return power;
    }
}
