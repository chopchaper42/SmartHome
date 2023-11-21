package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.creature.Creature;
import org.example.report.Reporter;

import java.util.List;

@Data
@AllArgsConstructor
public class House {
    private HouseControlSystem controlSystem;
    private List<HouseNode> houseComposition;
    private List<Creature> creatures;
    private Reporter reporter;
}
