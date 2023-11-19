package tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static String[] subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"};

    public static String[] hobbies = {"Reading", "Sports", "Music"};

    public static String[] gender = {"Male", "Female", "Other"};

    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);

    public String getRandomCity(String state) {
        String city = null;
        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (state.equals("Uttar Pradesh") ) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (state.equals("Haryana") ) {
            city =  faker.options().option("Karnal", "Panipat");
        }
        if (state.equals("Rajasthan") ) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }

        return city;
    }
}