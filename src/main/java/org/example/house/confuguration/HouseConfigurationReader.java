package org.example.house.confuguration;

import com.google.gson.JsonParser;
import org.example.creature.creatures_factory.AnimalTypes;
import org.example.creature.creatures_factory.HumanTypes;
import org.example.creature.creatures_factory.PeopleFactory;
import org.example.creature.creatures_factory.PetFactory;
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

import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    /**
     *
     * @param element
     * @param levelObj
     * @throws Exception
     */
    public void loadJson(String element, JSONObject levelObj) throws Exception {
        JSONArray array = (JSONArray) levelObj.get(element);
        switch (element) {
            case "creatures" -> loadCreatures(array);
            case "home" -> loadHome(array);
        }
    }


    private void loadHome(JSONArray array) {
        for (Object floor : (JSONArray) ((JSONObject) array.get(0)).get("floors")) {

            FloorBuilder floorBuilder = new FloorBuilder();
            int level = ((Long) (((JSONObject) floor).get("level"))).intValue();
            floorBuilder.setLevel(level);

            JSONArray rooms = (JSONArray) ((JSONObject) floor).get("rooms");
            for (Object room : rooms) {
                RoomBuilder roomBuilder = new RoomBuilder();

                String roomName = (String) ((JSONObject) room).get("name");
                roomBuilder.setRoomName(RoomTypes.valueOf(roomName.toUpperCase()));
                Room new_room = roomBuilder.build();
                JSONArray devices = (JSONArray) ((JSONObject) room).get("devices");
                //sport devices
                JSONArray sport_devices = (JSONArray) (((JSONObject) devices.get(0)).get("sport_devices"));
                if (!sport_devices.isEmpty()) {
                    for (Object sport_device : sport_devices) {
                        sportDeviceCreator.createDevice(new_room,
                                SportDeviceTypes.getTypeByName((String) ((JSONObject) sport_device).get("type")));
                    }
                }
                //entertainment devices
                JSONArray entertainment_devices = (JSONArray) (((JSONObject) devices.get(0)).get("entertainment_devices"));
                if (!entertainment_devices.isEmpty()) {
                    for (Object entertainment_device : entertainment_devices) {
                        entertainmentDeviceCreator.createDevice(new_room,
                                EntertainmentDeviceTypes.getTypeByName((String) ((JSONObject) entertainment_device).get("type")));
                    }
                }
                //kitchen devices
                JSONArray kitchen_devices = (JSONArray) (((JSONObject) devices.get(0)).get("kitchen_devices"));
                if (!kitchen_devices.isEmpty()) {
                    for (Object kitchen_device : kitchen_devices) {
                        kitchenDeviceCreator.createDevice(new_room,
                                KitchenDeviceTypes.getTypeByName((String) ((JSONObject) kitchen_device).get("type")));
                    }
                }
            }
        }
    }


    /**
     * Read living creatures from configuration file (animals - cats, people - children/adults)
     * @param array The JSON array representing living creatures in configuration file
     */
    private void loadCreatures(JSONArray array) {
        JSONArray animals = (JSONArray) ((JSONObject) array.get(0)).get("animals");
        if (!animals.isEmpty()) {
            JSONArray cats = (JSONArray) (((JSONObject) (animals.get(0))).get("cats"));
            if(!cats.isEmpty()) {
                for (Object cat : cats) {
                    String roomName = ((String) (((JSONObject) cat).get("room")));
                    petFactory.createCreature((String) (((JSONObject) cat).get("name")),
                            ((Long) (((JSONObject) cat).get("age"))).intValue(),
                            roomFactory.findRoomByName(roomName),
                            AnimalTypes.CAT);
                }
            }
        }
        JSONArray people = (JSONArray) ((JSONObject) array.get(0)).get("people");
        if (!people.isEmpty()) {
            JSONArray adults = (JSONArray) (((JSONObject) (people.get(0))).get("adults"));
            if (!adults.isEmpty()) {
                for (Object adult : adults) {
                    String roomName = ((String) (((JSONObject) adult).get("room")));
                    peopleFactory.createCreature((String) (((JSONObject) adult).get("name")),
                            ((Long) (((JSONObject) adult).get("age"))).intValue(),
                            roomFactory.findRoomByName(roomName),
                            HumanTypes.ADULT);
                }
            }
            JSONArray children = (JSONArray) (((JSONObject) (people.get(1))).get("children"));
            if (!children.isEmpty()) {
                for (Object child : children) {
                    String roomName = ((String) (((JSONObject) child).get("room")));
                    peopleFactory.createCreature((String) (((JSONObject) child).get("name")),
                            ((Long) (((JSONObject) child).get("age"))).intValue(),
                            roomFactory.findRoomByName(roomName),
                            HumanTypes.CHILD);
                }

            }
        }
    }


}
