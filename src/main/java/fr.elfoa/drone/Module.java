package fr.elfoa.drone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class Module {

    @Column
    private Integer power = 100;

    @ManyToOne
    private Battery battery;
    
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
