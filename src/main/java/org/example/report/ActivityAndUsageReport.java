package org.example.report;

import org.example.creature.Creature;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class ActivityAndUsageReport extends Report {
    private List<Creature> creatures;
    public ActivityAndUsageReport(List<Creature> creatures) throws FileNotFoundException {
        super(new File("./src/main/reports/activityAndUsageReport.txt"));
        this.creatures = creatures;
    }

    @Override
    public void generateReport() {
        for (Creature creature : creatures) {
            writer.println("\t" + creature.getName() + ":");
            for (Map.Entry<String, Integer> e : creature.getUsageJournal().entrySet())
                writer.println("Device: " + e.getKey() + "; Used: " + e.getValue());
        }
        writer.close();
    }
}
