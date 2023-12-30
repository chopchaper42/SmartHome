package org.example.house.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.device.Device;
import org.example.device.DeviceTypes;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Room {

    private RoomType type;
    private List<Device> devices;
    private Set<Room> nearRooms;

    /**
     * Connects current room with the room passed as an argument.
     * @param room the room to connect with.
     * @return the newly connected room.
     */
    public Room connectTo(Room room) {
        nearRooms.add(room);
        room.nearRooms.add(this);
        return room;
    }

//    public Device getDevice(DeviceTypes type)
}
