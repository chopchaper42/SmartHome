package org.example.report;

/**
 * Interface for reporting. Implementations of Report are Singleton patterns
 */
public interface Report {
   void generateReport(String filename);
}
