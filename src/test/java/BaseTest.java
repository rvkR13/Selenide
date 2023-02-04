import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        // Configuration.baseUrl ="https://demoqa.com";
    }
}