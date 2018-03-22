package fr.elfoa.drone.Battery;

import fr.elfoa.drone.Annotations.BatteryType;
import fr.elfoa.drone.Annotations.ModuleType;
import fr.elfoa.drone.Module;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Pierre Colomb
 */
@ApplicationScoped
@BatteryType(ModuleType.STANDARD)
public class Battery implements IBattery{

    @OneToMany(mappedBy = "battery")
    private List<Module> modules = new ArrayList<>();

    @Inject
    public Battery(){
        modules = Arrays.asList(new Module(100),
                                new Module(100),
                                new Module(100),
                                new Module(100));
    }

    public void use(Integer power){
        Module module = modules.stream()
                .filter(m -> m.getPower() != 0)
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new);

        module.use(power);

    }

    public Integer getPower(){
        return modules.stream()
                .mapToInt(Module::getPower)
                .sum();
    }

}
