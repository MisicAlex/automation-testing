package dataGenerator;

import com.github.javafaker.Faker;

public class DataCreation {
    public static String generateFirstName(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }
    public static String generateLastName(){
        return new Faker().name().lastName();
    }
    public static String generatePostalCode(){
        return new Faker().address().zipCode();
    }
}
