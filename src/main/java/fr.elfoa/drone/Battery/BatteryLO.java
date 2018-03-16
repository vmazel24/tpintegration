package fr.elfoa.drone.Battery;

import fr.elfoa.drone.Annotations.BatteryType;
import fr.elfoa.drone.Annotations.ModuleType;
import fr.elfoa.drone.Module;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@BatteryType(ModuleType.LITHIUM_OXYGEN)
public class BatteryLO implements IBattery{
    private List<Module> modules = new ArrayList<>();

    @Inject
    public BatteryLO(){
        modules = Arrays.asList(new Module(200),
                new Module(200),
                new Module(200),
                new Module(200));
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
