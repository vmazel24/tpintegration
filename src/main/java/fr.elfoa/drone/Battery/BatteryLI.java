package fr.elfoa.drone.Battery;

import fr.elfoa.drone.Annotations.BatteryType;
import fr.elfoa.drone.Annotations.ModuleType;
import fr.elfoa.drone.Module;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
@BatteryType(ModuleType.LITHIUM_ION)
public class BatteryLI implements IBattery{
    private List<Module> modules = new ArrayList<>();

    @Inject
    public BatteryLI(){
        modules = Arrays.asList(new Module(150),
                new Module(150),
                new Module(150),
                new Module(150));
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
