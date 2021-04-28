package helper;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

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

    public static String getDepartDateRandom() {
        Calendar cal = Calendar.getInstance();
        int ranNum = ThreadLocalRandom.current().nextInt(4, 30);
        cal.add(Calendar.DATE, ranNum);
        return new SimpleDateFormat("M/d/yyyy").format(cal.getTime());
    }

    public static String getBookDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("M/d/yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getExpiredDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,3);
        return sdf.format(c.getTime());
    }
}
