package org.example;


import org.example.creature.Creature;
import org.example.events.Day;
import org.example.events.Night;
import org.example.house.House;

import java.util.logging.Logger;

public class Simulation {
    private static final Logger logger = Logger.getLogger(Simulation.class.getName());
    private static final int countOfActivities = 10;
    private static Simulation INSTANCE;

    /**
     *  Gets instance of existing Simulation or creates new Simulation - Singleton pattern
     * @return instance of simulation
     */
    public static Simulation getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Simulation();
        }
        return INSTANCE;
    }

    /**
     * Just method for printing greetings
     */
    public void printGreetings(){
        logger.info("\n" +
                "░██████╗███╗░░░███╗░█████╗░██████╗░████████╗██╗░░██╗░█████╗░███╗░░░███╗███████╗\n" +
                "██╔════╝████╗░████║██╔══██╗██╔══██╗╚══██╔══╝██║░░██║██╔══██╗████╗░████║██╔════╝\n" +
                "╚█████╗░██╔████╔██║███████║██████╔╝░░░██║░░░███████║██║░░██║██╔████╔██║█████╗░░\n" +
                "░╚═══██╗██║╚██╔╝██║██╔══██║██╔══██╗░░░██║░░░██╔══██║██║░░██║██║╚██╔╝██║██╔══╝░░\n" +
                "██████╔╝██║░╚═╝░██║██║░░██║██║░░██║░░░██║░░░██║░░██║╚█████╔╝██║░╚═╝░██║███████╗\n" +
                "╚═════╝░╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░╚════╝░╚═╝░░░░░╚═╝╚══════╝");
    }

    /**
     *
     */
    public void run(){
        for (int i = 0; i < House.getInstance().getDays(); i++) {
            new Day();
            for (int j = 0; j < countOfActivities; j++) {
                if (j == 7) {
                    new Night();
                }
                for (Creature creature : House.getInstance().getCreatures()) {
                    creature.everythingIsHappeningAsISaid();
                }
            }
        }
    }
}
