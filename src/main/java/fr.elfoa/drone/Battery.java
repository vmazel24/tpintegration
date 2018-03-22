package fr.elfoa.drone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class Battery {

    @OneToOne
    private Propellers propellers;

    @OneToMany(mappedBy = "battery")
    private List<Module> modules = new ArrayList<>();


    public Battery(){
        modules = Arrays.asList(new Module(),
                                new Module(),
                                new Module(),
                                new Module());
    }

    void use(Integer power){
        Module module = modules.stream()
                               .filter(m -> m.getPower() != 0)
                               .findFirst()
                               .orElseThrow(UnsupportedOperationException::new);

        module.use(power);

    }

    Integer getPower(){
        return modules.stream()
                      .mapToInt(Module::getPower)
                      .sum();
    }

}
