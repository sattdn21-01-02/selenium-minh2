package helper;


import org.apache.log4j.Logger;

public class LoggerHelper {

    private static Logger LoggerHelper = Logger.getLogger(LoggerHelper.class.getName());

    public static void startTestCase(String sTestCaseName) {
        info("--------- " + sTestCaseName + " ---------\n");
    }

    //This is to print log for the ending of the test case
    public static void endTestCase() {
        info("--------- END TEST CASE: ---------");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        LoggerHelper.info(message);
    }

    public static void warn(String message) {
        LoggerHelper.warn(message);
    }

    public static void error(String message) {
        LoggerHelper.error(message);
    }

    public static void fatal(String message) {
        LoggerHelper.fatal(message);
    }

    public static void debug(String message) {
        LoggerHelper.debug(message);
    }
}
