package org.example.house.room;

import lombok.Getter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.devices.Lamp.Lamp;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Room {

    private String id;
    private Set<Creature> creatures = new HashSet<>();
    private Set<Device> devices = new HashSet<>();

    public Room(String id) {
        this.id = id;
    }

    public void onCreatureEnter() {
        if (creatures.size() == 1) {
            List<Device> lamps = devices.stream().filter(d -> d.getClass() == Lamp.class).toList();
            lamps.forEach(Device::on);
        }
    }

    public void onCreatureLeft() {
        if (creatures.isEmpty()) {
            List<Device> lamps = devices.stream().filter(d -> d.getClass() == Lamp.class).toList();
            lamps.forEach(Device::off);
        }
    }

    public void addCreature(Creature c) {
        creatures.add(c);
        onCreatureEnter();
    }

    public void removeCreature(Creature c) {
        creatures.remove(c);
        onCreatureLeft();
    }

    public void addDevice(Device d) {
        devices.add(d);
    }

    public void addAllDevices(Collection<Device> d) {
        devices.addAll(d);
    }


    public <T extends Device> List<T> devicesByType(Class<T> clazz) {
        return getDevices().stream().filter(it->clazz.isAssignableFrom(it.getClass())).map(it->(T)it).collect(Collectors.toList());
    }

    public String consumptionReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(":\n");
        for (Device dev : devices) {
            sb.append("\t").append(dev).append('\n');
            sb.append("\t\tElectricity consumed: ").append(dev.getConsumedElectricity()).append('\n');
        }
        return sb.toString();
    }
}
