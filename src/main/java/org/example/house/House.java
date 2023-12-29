package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.creature.Creature;
import org.example.house.strategy.Strategy;
import org.example.report.Reporter;

import java.util.List;

@Data
@AllArgsConstructor
public class House {
    private HouseControlSystem controlSystem;
    private List<HouseNode> houseComposition;
    public List<Creature> creatures;
    private List<Floor> floors;
    private Reporter reporter;

    private Strategy strategy;  //???

    public void strategyScenario() {
        strategy.everythingIsHappeningAsISaid(creatures);
    }

    //SETTERS
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    } //House.setStrategy(new NightStrategy()); House.strategyScenario();

}
