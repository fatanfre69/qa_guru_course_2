package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class GoogleTest {
    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }



    @Test
    void visaUsaSearchTest() {
//        Открыть Google
        open("https://google.com");

//        Ввести "visa USA"
        $(byTitle("Поиск")).setValue("visa USA");

//        Клик по Поиску
        $(byName("btnK")).click();

//        Проверить, что visa USA появился в результате поиска
        $("body").shouldHave(text("ru.usembassy.gov"));
    }



    @Test
    void longSearchTest() {
//        Открыть Google
        open("https://google.com");

//        Ввести "Как мне открыть банку варенья без открывашки"
        $(byName("q")).setValue("Как мне открыть банку варенья без открывашки").pressEnter();

//        Проверить, что в результате поиска есть заданный текст
        $("body").shouldBe(text("Как открыть банку с вареньем"));
    }

}
