package fr.elfoa.drone;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Pierre Colomb
 */
@Entity
public class Container {

    private static final Integer SIZE = 100;

    @OneToMany(mappedBy = "container")
    private Set<Item> items = new HashSet<>();

    public Container(){
        this.items = new HashSet<>();
    }


    public void load (Item item){
        items.add(item);
    }

    public Integer getWeight(){
        return items.stream()
                    .mapToInt(Item::getWeight)
                    .sum();
    }


}
