package org.example.house;

import lombok.Builder;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.environment.Environment;
import org.example.house.alertSystem.AlertSystem;
import org.example.sensor.*;

import java.util.List;

@Builder
public class HouseControlSystem {
    private static HouseControlSystem system;

    private List<Device> devices;

    private AlertSystem alertSystem;
    private Environment environment;

    public void subscribeOnAlertSystem(Creature c) {
        alertSystem.subscribe(c);
    }

    private void alert() {
//        alertSystem
    }

    private HouseControlSystem() {}

    public static HouseControlSystem getInstance() {
        if (system == null)
            system = new HouseControlSystem();

        return system;
    }
}
