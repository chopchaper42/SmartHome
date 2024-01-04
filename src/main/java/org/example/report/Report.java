package org.example.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Report {
    protected PrintWriter writer;

    public Report(File file) throws FileNotFoundException {
        writer = new PrintWriter(file);
    }
}
