package org.example.report;

public class ConsumptionReport implements Report{
    private static ConsumptionReport instance;
    @Override
    public void generateReport() {

    }

    public static ConsumptionReport getInstance() {
        if(instance == null) {
            instance = new ConsumptionReport();
            //instance.events = new ArrayList<>();
        }
        return instance;
    }
}
