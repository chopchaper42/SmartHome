package org.example.configuration;

import org.example.creature.Creature;
import org.example.house.HouseControlSystem;
import org.example.house.HouseNode;

import java.util.List;

public record HouseConfiguration(HouseControlSystem controlSystem, List<HouseNode> houseNodes, List<Creature> creatures) {
}
