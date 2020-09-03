package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class just_simple_test {
    @Test
    void searchNothingTestPositive() {
        open("https://google.com");
        $(byName("q")).setValue("Nothing").pressEnter();
        $("html").shouldHave(text("Nothing"));
    }

    @Test
    void searchNothingTestPNegative() {
        open("https://google.com");
        $(byName("q")).setValue("Ничего").pressEnter();
        $("html").shouldHave(text("Nothing"));
    }


}
