import org.junit.jupiter.api.Test;
import page.PagePracticeForm;
import page.PopUpCalendar;

import static com.codeborne.selenide.Selenide.open;


public class PracticeFormTest extends BaseTest {
    String FIRSTNAME = DataGenerator.getRandomFirstName();
    String LASTNAME = DataGenerator.getRandomLastName();
    String GENDER = DataGenerator.getRandomGender();
    String NUMBER = DataGenerator.getRandomNumber();
    String ADDRESS = DataGenerator.getRandomAddress();
    PagePracticeForm pagePracticeForm = new PagePracticeForm();
    PopUpCalendar popUpCalendar = new PopUpCalendar();

    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
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
}