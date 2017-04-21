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

    private static final List<String> REPORT_TESTNAME   = new ArrayList<>();
    private static final List<String> REPORT_EXPECTED   = new ArrayList<>();
    private static final List<String> REPORT_ACTUAL     = new ArrayList<>();

    private static final List<String> REPORT            = new ArrayList<>();

    private static FileWriter writer;

    public static void report(Double expected, Double actual, String testName) {
//        REPORT_TESTNAME.add(testName);
//        REPORT_EXPECTED.add(String.valueOf(expected));
//        REPORT_ACTUAL.add(String.valueOf(actual));
        REPORT.add(testName);
        REPORT.add(String.valueOf(expected));
        REPORT.add(String.valueOf(actual));

    }

    public static void init(String classNameReport) {
        try {
            writer = new FileWriter("./" + classNameReport + ".report.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write() {
        try {
//            CSVWriter.writeLine(writer, REPORT_TESTNAME);
//            CSVWriter.writeLine(writer, REPORT_EXPECTED);
//            CSVWriter.writeLine(writer, REPORT_ACTUAL);
            CSVWriter.writeLine(writer, REPORT);
            REPORT.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void flush() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            REPORT_TESTNAME.clear();
            REPORT_ACTUAL.clear();
            REPORT_EXPECTED.clear();
        }
    }
}
