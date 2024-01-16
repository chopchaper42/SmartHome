package org.example.report;

public class EventReport implements Report{
    private static EventReport instance;
    @Override
    public void generateReport() {
    }

    public static EventReport getInstance() {
        if(instance == null) {
            instance = new EventReport();
            //instance.events = new ArrayList<>();
        }
        return instance;
    }
}
