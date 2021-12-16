package homeworks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class FirstHomeWork {

    @BeforeEach
    void start() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void checkForms() {

        $("\t#firstName").setValue("Darya");
        $("\t#lastName").setValue("Miloradova");
        $("\t#userEmail").setValue("d.miloradov@mail.ru");

        $("[for='gender-radio-3]").click();
        $("#userNumber").setValue("89999999999");

        $x("//*[@id='dateOfBirthInput']").click();
        $x("//*[normalize-space()='29']").click();

        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Commerce").pressEnter();

        $x("//label[normalize-space()='Music']").click();

        File file = new File("src/test/java/resources/pozitivnye_kartinki_2.jpg");
        $("input[id='uploadPicture']").uploadFile(file);

        $("#currentAddress").setValue("Moscow, street New, 1");


        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $x("#submit").click();
    }

    @AfterEach
    void close() {
        closeWebDriver();
    }
}
