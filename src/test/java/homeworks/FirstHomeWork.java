package homeworks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstHomeWork {

    @BeforeEach
    void start() {
//        Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }
    @Test
    void checkForms() {

        $("#firstName").setValue("Darya");
        $("#lastName").setValue("Miloradova");
        $("#userEmail").setValue("d.miloradov@mail.ru");

        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("89999999999");

        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption("July");
        $("[class='react-datepicker__year-select']").selectOption("1994");
        $("[class*='react-datepicker__day--010']").click();

        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Commerce").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("input[id='uploadPicture']").uploadFromClasspath("pozitivnye_kartinki_2.jpg");

        $("#currentAddress").setValue("Moscow street 1");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $(".modal-content").shouldHave(
                text("Darya Miloradova"),
                text("d.miloradov@mail.ru"),
                text("Female"),
                text("89999999999"),
                text("10 July,1994"),
                text("Biology Commerce"),
                text("Music"),
                text("pozitivnye_kartinki_2.jpg"),
                text("Moscow street 1"),
                text("NCR Delhi"));
    }
}
