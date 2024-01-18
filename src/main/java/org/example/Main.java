package org.example;


import org.example.house.House;
import org.example.report.ActivityAndUsageReport;
import org.example.report.ElectricityReport;
import org.example.report.EventReport;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        if (args.length < 4) {
            logger.info("You should write 4 arguments (your files)");
        }
        House.getInstance(args[0]);
        Simulation simulation = Simulation.getInstance();
        if (House.getInstance() != null) {
            simulation.printGreetings();
            simulation.run();
            EventReport.getInstance().generateReport(args[1]);
            ElectricityReport.getInstance().generateReport(args[2]);
            ActivityAndUsageReport.getInstance().generateReport(args[3]);
        }
    }
}