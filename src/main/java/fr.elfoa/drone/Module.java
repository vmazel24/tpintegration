package fr.elfoa.drone;

/**
 * @author Pierre Colomb
 */
public class Module {

    private Integer power;

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
