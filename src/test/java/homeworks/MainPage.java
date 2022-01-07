package homeworks;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @BeforeEach
    void start() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void checkForms() {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.number().digits(10);

        $("#firstName").setValue("Darya");
        $("#lastName").setValue("Miloradova");
        $("#userEmail").setValue("d.miloradov@mail.ru");

        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999999999");

        Calendar calendar = new Calendar();
        calendar.chooseCalendar();

        Interests interests = new Interests();
        interests.setInterests();

        $("input[id='uploadPicture']").uploadFromClasspath("pozitivnye_kartinki_2.jpg");

        AddresInformation addresInformation = new AddresInformation();
        addresInformation.enterAddresInfo();
        $("#submit").click();

        $(".modal-content").shouldHave(
                text("Darya Miloradova"),
                text("d.miloradov@mail.ru"),
                text("Female"),
                text("8999999999"),
                text("10 July,1994"),
                text("Biology, Commerce"),
                text("Music"),
                text("pozitivnye_kartinki_2.jpg"),
                text("Moscow street 1"),
                text("NCR Delhi"));
    }
}
