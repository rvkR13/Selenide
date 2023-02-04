package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PagePracticeForm {

    private final SelenideElement formTitle = $("h5"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            inputNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbies-checkbox-3"),
            address = $("#currentAddress"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit");

    public static final String FORM_TITLE = "Student Registration Form";

    @Step("ввести FirstName ")
    public final PagePracticeForm inputFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("ввести LastName ")
    public final PagePracticeForm inputLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("ввести email ")
    public final PagePracticeForm inputEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Открыть страницу /automation-practice-form")
    public final PagePracticeForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Choose Gender")
    public final PagePracticeForm chooseGender(String value) {
        genderInput.shouldHave(text(value)).click();
        return this;
    }

    @Step("set number")
    public final PagePracticeForm setNumber(String value) {
        inputNumber.setValue(String.valueOf(value));
        return this;
    }

    @Step("subjects Input")
    public final PagePracticeForm subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Choose hobbies")
    public final PagePracticeForm chooseHobbies() {
        hobbies.parent().click();
        return new PagePracticeForm();
    }

    @Step("Input address")
    public final PagePracticeForm inputAddress(String value) {
        address.setValue(value);
        return new PagePracticeForm();
    }

    @Step("Choose state")
    public final PagePracticeForm chooseState() {
        state.click();
        return new PagePracticeForm();
    }

    @Step("Choose State")
    public final PagePracticeForm selectState() {
        stateCity.$(byText("NCR")).click();
        return new PagePracticeForm();
    }

    @Step("Choose City")
    public final PagePracticeForm chooseCity() {
        city.click();
        return new PagePracticeForm();
    }

    @Step("Select City")
    public final PagePracticeForm selectCity() {
        stateCity.$(byText("Noida")).click();
        return new PagePracticeForm();
    }

    @Step("Select submit")
    public final PagePracticeForm selectSubmit() {
        submit.click();
        return new PagePracticeForm();
    }

    @Step("Проверка")
    public void check(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
    }
}