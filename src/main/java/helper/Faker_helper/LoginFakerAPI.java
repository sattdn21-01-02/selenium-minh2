package helper.Faker_helper;

import com.github.javafaker.Faker;

public class LoginFakerAPI {
    Faker faker = new Faker();

    public String getEmail() {
        //Generating the email name
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String getPassword() {
        //Generating password
        String pwd = faker.internet().password();
        return pwd;
    }
}
