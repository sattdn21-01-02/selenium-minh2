package helper;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {

    public static String getRandomValidEmail() {
        Faker faker = new Faker();
        return faker.bothify("email######@gmail.com");
    }

    public static String getRandomValidPassword() {
        Faker faker = new Faker();
        return faker.bothify("??????######");
    }

    public static String getRandomValidPid() {
        Faker faker = new Faker();
        return faker.bothify("########");
    }

    public static String getRandomErrorEmail() {
        Faker faker = new Faker();
        return faker.bothify("?????");
    }

    public static String getRandomErrorPassword() {
        Faker faker = new Faker();
        return faker.bothify("???????");
    }

    public static String getRandomErrorPid() {
        Faker faker = new Faker();
        return faker.bothify("#######");
    }

    public static String getRandomValidDepartDate() {
        Calendar cal = Calendar.getInstance();
        int ranNum = ThreadLocalRandom.current().nextInt(4, 30);
        cal.add(Calendar.DATE, ranNum);
        return new SimpleDateFormat(Constant.DATE_FORMAT).format(cal.getTime());
    }

    public static String getToday() {
        SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_FORMAT);
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String get3PlusDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_FORMAT);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 3);
        return sdf.format(c.getTime());
    }
}
