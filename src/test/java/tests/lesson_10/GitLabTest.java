package tests.lesson_10;

import WebDriverProvider.WebDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class GitLabTest {

    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testsMainPage(){
        driver.get("https://gitlab.com");
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }


}
