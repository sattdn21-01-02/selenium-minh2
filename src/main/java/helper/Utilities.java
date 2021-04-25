package helper;

import java.io.File;

public class Utilities {

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static File readFile(String fileName) {
        File file = new File(Utilities.getProjectPath() + Constant.TEST_RESOURCES_PATH + fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
