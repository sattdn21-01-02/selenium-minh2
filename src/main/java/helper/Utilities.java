package helper;

import com.github.javafaker.Faker;

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

    public static String generateRandomEmailString() {
        Faker faker = new Faker();
        return faker.bothify("email####@gmail.com");
    }

    public static String generateRandomPasswordString() {
        Faker faker = new Faker();
        return faker.bothify("?????#####");
    }

    public static String generateRandomPidString() {
        Faker faker = new Faker();
        return faker.bothify("########");
    }

    public static String generateRandomErrorEmailString() {
        Faker faker = new Faker();
        return faker.bothify("?????");
    }

    public static String generateRandomErrorPasswordString() {
        Faker faker = new Faker();
        return faker.bothify("???????");
    }

    public static String generateRandomErrorPidString() {
        Faker faker = new Faker();
        return faker.bothify("#######");
    }
}
