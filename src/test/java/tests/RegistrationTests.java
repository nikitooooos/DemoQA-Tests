package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;
import static utils.RandomUtils.*;
public class RegistrationTests extends TestBase {

    Faker faker = new Faker();
    TestData testData = new TestData();
    @Test
    @Tag("remote")
    @DisplayName("Проверка регистрации")
    void successfulRegistrationTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(gender),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = String.valueOf(faker.number().numberBetween(10, 28)),
                monthOfBirth = getRandomItemFromArray(months),
                yearOfBirth = String.valueOf(getRandomInt(1900,2100)),
                subject = getRandomItemFromArray(subjects),
                randomHobbies = getRandomItemFromArray(hobbies),
                picture = "test.jpg",
                currentAddress = faker.address().streetAddress(),
                randomState = testData.state,
                randomCity = testData.city;

        step("Открываем страницу", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя", () -> {
            registrationPage.setFirstName(firstName);
        });

        step("Вводим фамилию", () -> {
            registrationPage.setLastName(lastName);
        });

        step("Вводим email", () -> {
            registrationPage.setEmail(userEmail);
        });

        step("Выбираем пол", () -> {
            registrationPage.setGender(userGender);
        });

        step("Вводим номер телефона", () -> {
            registrationPage.setUserNumber(userNumber);
        });

        step("Вводим дату рождения", () -> {
            registrationPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        });

        step("Выбираем предмет", () -> {
            registrationPage.setSubjects(subject);
        });

        step("Выбираем хобби", () -> {
            registrationPage.selectHobbies(randomHobbies);
        });

        step("Загружаем фотографию", () -> {
            registrationPage.upLoadPictureInput(picture);
        });

        step("Выбираем адресс", () -> {
            registrationPage.setCurrentAddress(currentAddress);
        });

        step("Выбираем штат и город", () -> {
            registrationPage.selectStateCity(randomState, randomCity);
        });

        step("Кликаем на кнопку submit", () -> {
            registrationPage.submit();
        });

        step("Проверка результата", () -> {
            registrationPage.checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", userGender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", randomHobbies)
                    .checkResult("Picture", picture)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", randomState + " " + randomCity);
         });
    }
}