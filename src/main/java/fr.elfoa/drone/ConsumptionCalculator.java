package fr.elfoa.drone;

import javax.inject.Inject;

/**
 * @author Pierre Colomb
 */
public class ConsumptionCalculator {

    @Inject
    public ConsumptionCalculator()
    {
    }

    public Integer getConsumption(Integer propeller){
        return 0;
    }


    public Integer getConsumption(Double distance,Direction direction,Integer weight){
        return 0;
    }



}
