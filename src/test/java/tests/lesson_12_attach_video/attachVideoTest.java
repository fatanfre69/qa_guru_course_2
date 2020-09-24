package tests.lesson_12_attach_video;

import org.junit.jupiter.api.*;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class attachVideoTest extends TestBase {

    @Test
    @Tag("attach_video")
    public void attachVideoTests()  {
//        Configuration.headless = true;

            open("https://google.com");
            $(byName("q")).setValue("Selenide").pressEnter();
            $("html").shouldHave(text("ru.selenide.org"));

    }
}
