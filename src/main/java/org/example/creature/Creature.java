package org.example.creature;

import lombok.Getter;
import org.example.Dispatcher;
import org.example.house.room.Room;

@Getter
public class Creature {
    String name;
    Room currentRoom;

    public Creature(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public void goToNewLocation() {
        currentRoom.removeCreature(this);
        currentRoom = Dispatcher.getInstance().getRandomRoom();
        currentRoom.addCreature(this);
    }
}
