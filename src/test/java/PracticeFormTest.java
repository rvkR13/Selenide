import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillFormTest() {
        $("#firstName").setValue("111");
        $("#lastName").setValue("34567");
        $("#userEmail").setValue("er@ee.ru");
        $$("label.custom-control-label").filter(text("Female")).get(0).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2006");
        $("[aria-label=\"Choose Thursday, June 15th, 2006\"]").click();
        $("#dateOfBirth").click();
        $("#subjectsInput").setValue("history").pressEnter();
        $("#hobbies-checkbox-3").parent().click();
        $("#currentAddress").setValue("jyhg");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();


        $x("//td[text()='Student Name']").parent().shouldHave(text("111 34567"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("er@ee.ru"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Female"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("1111111111"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("15 June,2006"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("History"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Music"));
        $x("//td[text()='Address']").parent().shouldHave(text("jyhg"));
        $x("//td[text()='Address']").parent().shouldHave(text("jyhg"));
        $x("//td[text()='State and City']").parent().shouldHave(text("NCR Noida"));
    }
}