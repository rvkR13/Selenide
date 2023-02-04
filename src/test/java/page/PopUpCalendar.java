package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PopUpCalendar {
    SelenideElement openPopUp = $("#dateOfBirthInput"),

    selectMonth = $(".react-datepicker__month-select"),
            selectYear = $(".react-datepicker__year-select"),
            selectDay = $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)"),
            closedPopUp = $(".practice-form-wrapper");

    @Step("Open Pop-Up calendar")
    public final PopUpCalendar setData() {
        openPopUp.click();
        return this;
    }

    @Step("Select month")
    public final PopUpCalendar setMonth(String value) {
        selectMonth.selectOption(value);
        return this;
    }

    @Step("Select day")
    public final PopUpCalendar setDay() {
        selectDay.click();
        return this;
    }

    @Step("Select year")
    public final PopUpCalendar setYear(String value) {
        selectYear.selectOption(value);
        return this;
    }

    @Step("Closed pop up")
    public final PopUpCalendar closedPopUp() {
        closedPopUp.click();
        return this;
    }
}