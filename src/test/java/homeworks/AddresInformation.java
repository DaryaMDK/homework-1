package homeworks;

import static com.codeborne.selenide.Selenide.$;

public class AddresInformation {
    public void enterAddresInfo(){
        $("#currentAddress").setValue("Moscow street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
    }
}
