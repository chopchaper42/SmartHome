package org.example;

import org.example.creature.Creature;
import org.example.house.room.Room;
import org.example.location.Location;
import org.example.sensor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SmartHomeApplication {
    public static void main(String[] args) {

        Room location = new Room("Living Room");
        Room location2 = new Room("Bedroom");
        Creature creature = new Creature("John", location);

        Dispatcher dispatcher = Dispatcher.getInstance();

        dispatcher.addLocation(location);
        dispatcher.addLocation(location2);

        creature.goToNewLocation();

    }
}