package org.example.house;

import lombok.Getter;
import org.example.TaskSource;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.devices.Lamp.Lamp;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Room implements TaskSource {

    private String id;
    private Set<Creature> creatures = new HashSet<>();
    private Set<Device> devices = new HashSet<>();

    public Room(String id) {
        this.id = id;
    }

    /**
     * Turns all lamp on
     */
    public void onCreatureEnter() {
        List<Device> lamps = devices.stream().filter(d -> d.getClass() == Lamp.class).toList();
        lamps.forEach(Device::on);
    }

    /**
     * Turns all lams off is there is no creatures left in the room
     */
    public void onCreatureLeft() {
        if (creatures.isEmpty()) {
            List<Device> lamps = devices.stream().filter(d -> d.getClass() == Lamp.class).toList();
            lamps.forEach(Device::off);
        }
    }

    /**
     * Adds the creature to the creatures list
     * @param c the creature to add
     */
    public void addCreature(Creature c) {
        creatures.add(c);
        onCreatureEnter();
    }

    /**
     * Removes the creature from the creatures list
     * @param c the creature to remove
     */
    public void removeCreature(Creature c) {
        creatures.remove(c);
        onCreatureLeft();
    }

    /**
     * Adds the device to the devices list
     * @param d the device to add
     */
    public void addDevice(Device d) {
        devices.add(d);
    }

    /**
     * Adds the collection of devices to the devices list
     * @param d the collection to add
     */
    public void addAllDevices(Collection<Device> d) {
        devices.addAll(d);
    }

    /**
     * Returns all devices of the given type
     * @param clazz the type of devices to return
     * @return List of devices of class clazz
     * @param <T> Device inheritors
     */
    public <T extends Device> List<T> devicesByType(Class<T> clazz) {
        return getDevices().stream().filter(it->clazz.isAssignableFrom(it.getClass())).map(it->(T)it).collect(Collectors.toList());
    }

    /**
     * Returns true if the room has a device of the given type, false otherwise
     * @param clazz the class of a device to check if the room has
     * @return
     * @param <T> Device inheritors
     */
    public <T extends Device> boolean hasDevice(Class<T> clazz) {
        return !devicesByType(clazz).isEmpty();
    }

    /**
     * Returns a formatted string with the data about consumption of the device
     * @return consumption report string
     */
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
