package homeworks;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Interests {
    public  void setInterests(){
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
    }
}
