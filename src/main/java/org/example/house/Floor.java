package org.example.house;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Floor extends HouseNode {
    private final int number; //?? co to je
    private final List<Room> rooms = new ArrayList<>();
}
