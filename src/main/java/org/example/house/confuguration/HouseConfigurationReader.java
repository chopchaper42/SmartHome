package org.example.house.confuguration;

import com.google.gson.JsonParser;
import org.example.creature.Creature;
import org.example.creature.creatures_factory.AnimalTypes;
import org.example.creature.creatures_factory.HumanTypes;
import org.example.creature.creatures_factory.PeopleFactory;
import org.example.creature.creatures_factory.PetFactory;
import org.example.device.Device;
import org.example.device.EntertainmentDeviceTypes;
import org.example.device.KitchenDeviceTypes;
import org.example.device.SportDeviceTypes;
import org.example.device.device_factory.*;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.floors.Floor;
import org.example.house.floors.FloorBuilder;
import org.example.house.room_factory.RoomBuilder;
import org.example.house.room_factory.RoomFactory;
import org.example.house.room_factory.RoomTypes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;


import org.slf4j.Logger;

/**
 * Class for reading json-configuration file
 */
public class HouseConfigurationReader {

    //private final House
    private final ConstructionDeviceCreator constructionDeviceCreator = ConstructionDeviceCreator.getInstance();
    private final EntertainmentDeviceCreator entertainmentDeviceCreator = EntertainmentDeviceCreator.getInstance();
    private final KitchenDeviceCreator kitchenDeviceCreator = KitchenDeviceCreator.getInstance();
    private final SportDeviceCreator sportDeviceCreator = SportDeviceCreator.getInstance();
    private final PeopleFactory peopleFactory = PeopleFactory.getInstance();
    private final PetFactory petFactory = PetFactory.getInstance();
    private final RoomFactory roomFactory = RoomFactory.getInstance();
    private final House house = House.getInstance();

    //logger
    private static final Logger logger = LoggerFactory.getLogger(HouseConfigurationReader.class);



    public boolean loadJson(House house, String fileName) {
        JSONParser parser = new JSONParser();
        FileReader fileReader = null;
        JSONObject confFile = null;

        try(FileReader fileReader2 = new FileReader(fileName)) {
            fileReader = fileReader2;
            confFile =  (JSONObject) parser.parse(fileReader);
        } catch (Exception e) {
            logger.info("Configuration file not found");
            return false;
        }

        int days = ((Long)confFile.get("days")).intValue();
        house.setDays(days);
        List<Device> devices = new ArrayList<>();
        JSONArray JSONFloorList = new JSONArray();
        try {
            JSONFloorList.addAll((JSONArray)confFile.get("floors"));
        } catch (NullPointerException e) {
            logger.warn("NO FLOORS IN THE HOUSE!");
        }
        for (Object floor : JSONFloorList) {
            JSONObject JSONfloor = (JSONObject) floor;
            FloorBuilder floorBuilder = new FloorBuilder();
            int level = ((Long)JSONfloor.get("level")).intValue();
            floorBuilder.setLevel(level);
            JSONArray JSONRoomList = new JSONArray();
            try {
                JSONRoomList.addAll((JSONArray)JSONfloor.get("rooms"));
            } catch (NullPointerException e) {
                logger.warn("NO ROOMS ON THE FLOOR!");
            }
            if(JSONRoomList.size() == 0){
                logger.warn("No rooms on the floor");
            }
            Floor newFloor = readRoom(JSONRoomList, floorBuilder);
            house.addFloor(newFloor);
        }
        for (Floor newFloor : house.getFloors()) {
            for (Room room : newFloor.getRooms()) {
                devices.addAll(room.getDevices());
            }
        }
        house.setDevices(devices);
        //if(house.getDevicesList() != null){
        JSONArray JSONcreatures = new JSONArray();
        try {
            JSONcreatures.addAll((JSONArray) confFile.get("creatures"));
        } catch (NullPointerException e) {
            logger.warn("NO CREATURES ON THE FLOOR!");
        }

        for (Object creatureType : JSONcreatures) {
            JSONObject creatureTypeObject = (JSONObject) creatureType;
            JSONArray animals = (JSONArray) creatureTypeObject.get("animals");
            JSONArray people = (JSONArray) creatureTypeObject.get("people");
            // Process animals
            for (Object animal : animals) {
                JSONObject animalObject = (JSONObject) animal;
                String type = (String) animalObject.get("type");
                String name = (String) animalObject.get("name");
                int age = ((Long) animalObject.get("age")).intValue();
                int numberOfFloor = ((Long) animalObject.get("number_of_floor")).intValue();
                String roomName = (String)animalObject.get("room");
                List<Room> roooooooooooooooooooomList = house.getFloors().get(numberOfFloor-1).getRooms();
                Room roomForLiving = null;
                for (Room rooom : roooooooooooooooooooomList) {
                    if (Objects.equals(rooom.getRoomName(), roomName)) {
                        roomForLiving = rooom;
                    }
                }
                String nameOfRoom = (String) animalObject.get("name_of_room");
                Creature animalCreature = petFactory.createCreature(name, age,
                        roomForLiving,
                        AnimalTypes.CAT);
                animalCreature.setName(name);
                animalCreature.setCurrentRoom(roomForLiving);
                house.addCreatures(animalCreature);
            }
            // Process people
            for (Object person : people) {
                Creature humanCreature = null;
                JSONObject personObject = (JSONObject) person;
                String type = (String) personObject.get("type");
                String name = (String) personObject.get("name");
                int age = ((Long) personObject.get("age")).intValue();
                int numberOfFloor = ((Long) personObject.get("number_of_floor")).intValue();
                String roomName = (String)personObject.get("room");
                List<Room> roooooooooooooooooooomList = house.getFloors().get(numberOfFloor-1).getRooms();
                Room roomForLiving = null;
                for (Room rooom : roooooooooooooooooooomList) {
                    if (Objects.equals(rooom.getRoomName(), roomName)) {
                        roomForLiving = rooom;
                    }
                }
                String room = (String) personObject.get("room");
                switch (type) {
                    case "ADULT" :
                        humanCreature = peopleFactory.createCreature(name, age, roomForLiving, HumanTypes.ADULT); break;
                    case "CHILDREN" :
                        humanCreature = peopleFactory.createCreature(name, age, roomForLiving, HumanTypes.CHILD); break;
                }
                humanCreature.setName(name);
                humanCreature.setCurrentRoom(roomForLiving);
                house.addCreatures(humanCreature);
            }

        }
        return true;
    }
    public Floor readRoom(JSONArray roomListJSON, FloorBuilder builder){
        for(Object roomJSON: roomListJSON){
            Room room = loadDevices(roomJSON, builder.getLevel());
            if(room != null){
                builder.addRoom(room.getRoomName(), room);
            }
        }
        return builder.build();
    }

    private Room loadDevices(Object JSONroom, int level) {
        JSONObject room = (JSONObject) JSONroom;
        JSONArray JSONDeviceList = new JSONArray();
        try{
            JSONDeviceList.addAll( (JSONArray) room.get("devices"));
        } catch(NullPointerException e) {
            logger.warn("NO DEVICES IN THE ROOM!");
        }
        String nameOfRoom = (String)room.get("name");
        RoomBuilder roomBuilder = new RoomBuilder();
        //Room roomInstance = roomBuilder.build();
        roomBuilder.setNameOfRoom(nameOfRoom);
        Room roomInstance = roomBuilder.build();
        for(Object deviceJSON: JSONDeviceList){
            JSONObject deviceObj = (JSONObject) deviceJSON;
            String typeOfDevice = (String)deviceObj.get("device_type");
            String concreteDevice = (String)deviceObj.get("concrete_device");
            Device device = null;
            switch (typeOfDevice) {
                case "SPORT_DEVICE" :
                    device = sportDeviceCreator.createDevice(roomInstance,
                            SportDeviceTypes.getTypeByName(concreteDevice));
                    break;
                case "ENTERTAINMENT_DEVICE" :
                    device = entertainmentDeviceCreator.createDevice(roomInstance,
                            EntertainmentDeviceTypes.getTypeByName(concreteDevice));

                    break;
                case "KITCHEN_DEVICE" :
                    device = kitchenDeviceCreator.createDevice(roomInstance,
                            KitchenDeviceTypes.getTypeByName(concreteDevice));
                    break;
            }
            if(device != null){
                device.setNameOfDevice(concreteDevice);
                roomBuilder.addDevice(device);
            }
        }
        return roomInstance;
    }




}
