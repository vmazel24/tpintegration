package fr.elfoa.drone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class Item {

    @ManyToOne
    private Container container;

    @Column
    private Integer size;

    @Column
    private Integer weight;

    public Item(){
        size=0;
        weight=0;
    }

    public Integer getSize() {
        return size;
    }



    public Integer getWeight() {
        return weight;
    }
}
