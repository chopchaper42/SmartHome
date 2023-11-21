package org.example.house;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Floor extends HouseNode {
    int number;
    List<Room> rooms;
}
