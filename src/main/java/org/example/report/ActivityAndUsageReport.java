package org.example.report;

public class ActivityAndUsageReport implements Report{

    private static ActivityAndUsageReport instance;
    @Override
    public void generateReport() {

    }

    public static ActivityAndUsageReport getInstance() {
        if(instance == null) {
            instance = new ActivityAndUsageReport();
            //instance.events = new ArrayList<>();
        }
        return instance;
    }
}
