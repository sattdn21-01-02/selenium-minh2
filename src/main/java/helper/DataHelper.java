package helper;

import com.github.javafaker.Faker;

public class DataHelper {

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
