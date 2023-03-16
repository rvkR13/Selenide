import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.PagePracticeForm;
import page.PopUpCalendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends BaseTest {
    String FIRSTNAME = DataGenerator.getRandomFirstName();
    String LASTNAME = DataGenerator.getRandomLastName();
    String GENDER = DataGenerator.getRandomGender();
    String NUMBER = DataGenerator.getRandomNumber();
    String ADDRESS = DataGenerator.getRandomAddress();
    PagePracticeForm pagePracticeForm = new PagePracticeForm();
    PopUpCalendar popUpCalendar = new PopUpCalendar();
    @DisplayName("Проверка успешное заполнение всех полей формы")
    @Test
    void fillFormTest() {
        pagePracticeForm.openPage()
                .inputFirstName(FIRSTNAME)
                .inputLastName(LASTNAME)
                .inputEmail(String.valueOf(DataGenerator.EMAIL))
                .chooseGender(GENDER)
                .setNumber(NUMBER);

        popUpCalendar.setData()
                .setMonth("January")
                .setYear("2006")
                .setDay()
                .closedPopUp();
        pagePracticeForm.subjectsInput("history")
                .chooseHobbies()
                .inputAddress(ADDRESS)
                .chooseState()
                .selectState()
                .chooseCity()
                .selectCity()
                .selectSubmit();

        pagePracticeForm.check("Student Name", FIRSTNAME + " " + LASTNAME);
        pagePracticeForm.check("Student Email", DataGenerator.EMAIL);
        pagePracticeForm.check("Gender", GENDER);
        pagePracticeForm.check("Subjects", "History");
        pagePracticeForm.check("Hobbies", "Music");
        pagePracticeForm.check("Date of Birth", "30 January,2006");
        pagePracticeForm.check("Address", ADDRESS);
        pagePracticeForm.check("State and City", "NCR Noida");
    }

    @Test
    public void automationPracticeFormTest() {
        open("https://demoqa.com/automation-practice-form");
        // Fill out the form and submit
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        //  $("#sex-0").click();
     //   $("#exp-2").click();
     //   $("#datepicker").setValue("01/01/2020");
        $("#profession-1").click();
        $$(By.name("tool")).findBy(Condition.value("Selenium Webdriver")).click();
        $("#continents").selectOptionContainingText("Europe");
        $$(By.name("selenium_commands")).findBy(Condition.value("Switch Commands")).click();
        $(By.id("submit")).click();
        // Check that the form was submitted successfully
        $(".modal-body > p:nth-child(1)").shouldHave(text("First name: John"));
        $(".modal-body > p:nth-child(2)").shouldHave(text("Last name: Doe"));
        $(".modal-body > p:nth-child(3)").shouldHave(text("Sex: Male"));
        $(".modal-body > p:nth-child(4)").shouldHave(text("Years of experience: 2"));
        $(".modal-body > p:nth-child(5)").shouldHave(text("Date: 01/01/2020"));
        $(".modal-body > p:nth-child(6)").shouldHave(text("Profession: Manual Tester"));
        $(".modal-body > p:nth-child(7)").shouldHave(text("Automation Tool: Selenium Webdriver"));
        $(".modal-body > p:nth-child(8)").shouldHave(text("Continents: Europe"));
        $(".modal-body > p:nth-child(9)").shouldHave(text("Selenium Commands: Switch Commands"));
        // Close the pop up window
        $(By.className("modal-footer")).$(By.tagName("button")).click();
    }
}