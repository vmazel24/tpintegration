package fr.elfoa.drone;

import javax.inject.Inject;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class ConsumptionCalculator {

    @Inject
    public ConsumptionCalculator()
    {
    }
    @OneToOne
    private Propellers propellers;

    @OneToOne
    private Drone drone;

    Integer getConsumption(Integer propeller){
        return 0;
    }


    public Integer getConsumption(Double distance,Direction direction,Integer weight){
        return 0;
    }



}
