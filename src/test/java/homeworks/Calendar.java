package homeworks;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void chooseCalendar(){
        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption("July");
        $("[class='react-datepicker__year-select']").selectOption("1994");
        $("[class*='react-datepicker__day--010']").click();
    }
}
