package fr.elfoa.drone;

import fr.elfoa.drone.Annotations.*;
import fr.elfoa.drone.Battery.IBattery;
import fr.elfoa.drone.Propellers.Propellers4;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class Drone {

    @Inject
    @ManyToOne
    @BatteryType(ModuleType.STANDARD)
    private IBattery battery;
    

    @Inject
    @PropellersType(PropellersNumber.FOUR)
    @ManyToOne
    private Propellers4 propellers;
    

    @OneToMany
    private List<Container> containers;

    @Inject
    @OneToOne(mappedBy = "drone")
    private ConsumptionCalculator consumptionCalculator;
   

    @OneToOne
    private Point current;

    @Column
    private Boolean isFlying;

    @Inject
    public Drone(Point point){
        this.containers = new ArrayList<>();
        current = point;

        if(current.getAltitude() != 0){
            throw new IllegalArgumentException();
        }

    }

    public void tackOff()
    {

        if (!isCanFly())
        {
            return;
        }

        Integer weight = containers.stream()
                .mapToInt(Container::getWeight)
                .sum();

        propellers.start();

        battery.use(consumptionCalculator.getConsumption(50d, Direction.VERTICAL, weight));

        current = new Point(current.getLatitude(), current.getLongitude(), 50d);

        isFlying = true;

    }

    public void flyTo(Point point)
    {

        if (!isFlying)
        {
            throw new IllegalStateException();
        }

        double distance = point.distanceTo(current);

        Integer weight = containers.stream()
                .mapToInt(Container::getWeight)
                .sum();

        battery.use(consumptionCalculator.getConsumption(distance, Direction.HORIZONTAL, weight));

        current = point;
    }

    public void landing()
    {

        Integer weight = containers.stream()
                .mapToInt(Container::getWeight)
                .sum();

        battery.use(consumptionCalculator.getConsumption(50d, Direction.VERTICAL, weight));

        current = new Point(current.getLatitude(), current.getLongitude(), 0d);

        propellers.stop();
    }

    public boolean isCanFly()
    {
        Integer weight = containers.stream()
                .mapToInt(Container::getWeight)
                .sum();

        return weight == 0 || (weight / propellers.getNumberOfPropelle() * 5) != 0;
    }

    public Point getCurrentPosition()
    {
        return current;
    }
}
