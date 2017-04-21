package lab.test.secondlab.util;

/*
 * Created by @GoodforGod on 21.04.2017.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Default Comment
 */
public class ReportManager {

    private static final List<String> REPORT = new ArrayList<>();

    public static void report(String report) {
        REPORT.add(report);
    }

    public static void report(Double expected, Double actual, String testName) {
        report("@" + testName + ": was expecting [" + expected + "] and actual value was [" + actual + "]");
    }

    public static List<String> getREPORT() {
        return REPORT;
    }

    public static void flush() {
        FileWriter writer;
        try {
            writer = new FileWriter("./report.csv");
            CSVWriter.writeLine(writer, REPORT);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            REPORT.clear();
        }
    }
}
