package org.example.creature.people;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.device_factory.EntertainmentDeviceCreator;
import org.example.device.device_factory.SportDeviceCreator;
import org.example.device.devices.entertainment.EntertainmentDeviceInterface;
import org.example.device.devices.sport.SportDeviceInterface;
import org.example.events.Event;
import org.example.events.EventType;
import org.example.events.creatures_events.AskingForFood;
import org.example.events.creatures_events.Eating;
import org.example.events.creatures_events.Relaxing;
import org.example.events.creatures_events.Sporting;
import org.example.events.observer.EventManager;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.strategy.HungryStrategy;
import org.example.house.strategy.RelaxingStrategy;
import org.example.house.strategy.SportStrategy;
import org.example.house.strategy.Strategy;


import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static org.example.events.EventType.NIGHT;
import static org.example.events.EventType.PET_WANT_TO_EAT;

@Getter
@Setter
public abstract class Person extends Creature {
    protected House house = House.getInstance();
    private static final Logger logger = Logger.getLogger(Person.class.getName());

    protected Person() {
        super();
        EventManager.getInstance().subscribe(PET_WANT_TO_EAT, this);
        EventManager.getInstance().subscribe(NIGHT, this);
    }

    /**
     * Person interacts with device
     * @param device target device
     */
    @Override
    public void interactWithDevice(Device device) {
        currentDevice = device;
        currentDevice.setFree(false);
        device.interact(this);
    }

    /**
     * Person is going to eat
     * @return true if there is food in fridge
     */
    public boolean goToEat(){
        Device device = findDevice("Fridge");
        if (device == null) {
            logger.warning("No fridge found in the current room. Unable to eat.");
            return false;
        }
        new Eating(this);
        goToAnotherRoom(device.getCurrentRoom());
        currentDevice.setFree(false);
        logger.info(getName() + " has started eating.");
        return device.interact(this);
    }

    /**
     * Initiates the relaxation process for the person in the specified room.
     * Randomly selects an entertainment device from the available list, initiates the relaxation event,
     * and interacts with the selected device in the room.
     *
     */
    public void relax(){
        List<EntertainmentDeviceInterface> entertainmentDeviceInterfaceList = EntertainmentDeviceCreator.getInstance().getEntertainmentDeviceInterfaceList();
        if (entertainmentDeviceInterfaceList.isEmpty()) {
            logger.warning("No entertainment devices found");
            return;
        }
        new Relaxing(this);
        Random random = new Random();
        int deviceIndex = random.nextInt(entertainmentDeviceInterfaceList.size());
        EntertainmentDeviceInterface entertainmentDevice = entertainmentDeviceInterfaceList.get(deviceIndex);
        Device entertainmentDeviceTurnedToDevice = (Device) entertainmentDevice;
        //String nameOfDevice = entertainmentDeviceTurnedToDevice.getNameOfDevice();
        //entertainmentDeviceTurnedToDevice = findDevice(nameOfDevice);
        goToAnotherRoom(entertainmentDeviceTurnedToDevice.getCurrentRoom());
        if(entertainmentDeviceTurnedToDevice.interact(this)) {
            currentDevice = entertainmentDeviceTurnedToDevice;
            currentDevice.setFree(false);
        }
    }

    /**
     * Initiates the sporting activity for the person in the specified room.
     * Randomly selects a sport device from the available list, initiates the sporting event,
     * and interacts with the selected sport device in the room.
     *
     */
    public void sport(){
        List<SportDeviceInterface> sportDeviceInterfaceList = SportDeviceCreator.getInstance().getSportDeviceInterfaceList();
        if (sportDeviceInterfaceList.isEmpty()) {
            logger.warning("No sport devices found");
            return;
        }
        new Sporting(this);
        Random random = new Random();
        int deviceIndex = random.nextInt(sportDeviceInterfaceList.size());
        SportDeviceInterface sportDevice = sportDeviceInterfaceList.get(deviceIndex);
        Device sportDeviceTurnedToDevice = (Device) sportDevice;
        //String nameOfDevice = sportDeviceTurnedToDevice.getNameOfDevice();
        //sportDeviceTurnedToDevice = findDevice(nameOfDevice);
        goToAnotherRoom(sportDeviceTurnedToDevice.getCurrentRoom());
        if(sportDeviceTurnedToDevice.interact(this)) {
            currentDevice = sportDeviceTurnedToDevice;
            currentDevice.setFree(false);
        }

    }


    /**
     * Stops the eating activity for the person.
     * The device is freed.
     */
    public void stopEating(){
        logger.info(getName() + " has stopped eating.");
        if(currentDevice == null) {
            return;
        }
        freeDevice();
    }

    /**
     * Stops the relaxing activity for the person.
     * The device is turned off and freed.
     */
    public void stopRelaxing(){
        logger.info(getName() + " has stopped relaxing.");
        if(currentDevice == null) {
            return;
        }
        currentDevice.turnOff(this);
        freeDevice();
    }

    /**
     * Stops the sporting activity for the person.
     * The device is turned off and freed.
     */
    public void stopSporting(){
        logger.info(getName() + " has stopped sporting.");
        if(currentDevice == null) {
            return;
        }
        currentDevice.turnOff(this);
        freeDevice();
    }

    @Override
    public void update(Event event){
        if(event.getEventType() == EventType.PET_WANT_TO_EAT) {
            AskingForFood askingForFood = (AskingForFood) event;
            goToAnotherRoom(askingForFood.getAnimal().getCurrentRoom());
        }
    }

    @Override
    public void startingNewDay() {
        List<String> personStrategies = House.getInstance().getPersonStrategies();
        if (!personStrategies.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(personStrategies.size());
            String randomStrategyName = personStrategies.get(randomIndex);
            switch (randomStrategyName) {
                case "SportStrategy" :
                    this.strategy = new SportStrategy(); break;
                case "Hungry" :
                      this.strategy = new HungryStrategy(); break;
                default : this.strategy = new RelaxingStrategy(); break;
            }
            logger.info(name + " is treating by strategy " + randomStrategyName);
        }
    }
}
