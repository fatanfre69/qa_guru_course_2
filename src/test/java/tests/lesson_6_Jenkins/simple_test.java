package tests.lesson_6_Jenkins;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class simple_test {
    @Test
    @Tag("simple")
    void searchNothingTestPositive()  {
        int a = 1;
        assertEquals(a, 1);
    }

    @Test
    @Tag("simple")
    void searchNothingTestPNegative() {
        open("https://google.com");
        $(byName("q")).setValue("Ничего").pressEnter();
        $("html").shouldHave(text("Nothing"));
    }


}
