package fr.elfoa.drone;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class ConsumptionCalculator {

    @OneToOne
    private Propellers propellers;

    @OneToOne
    private Drone drone;

    Integer getConsumption(Integer propeller){
        return 0;
    }


    Integer getConsumption(Double distance,Direction direction,Integer weight){
        return 0;
    }



}
