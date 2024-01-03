package org.example.house;

import lombok.AllArgsConstructor;
import org.example.house.room.Room;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Floor {
    private final int number;
    private final List<Room> rooms = new ArrayList<>();
}
