import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }
}