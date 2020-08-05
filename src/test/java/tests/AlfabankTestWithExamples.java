package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTestWithExamples {

    @Test
    void archiveAlfaBankTest() {
// открывать сайт Альфа Банк
        open("https://alfabank.ru/");

//        Клик по "Вклады"
        $(byText("Вклады")).click();

//        Найти на странице текст "Вклады и инвестиции"
        $("html").shouldHave(text("Вклады и инвестиции"));

//        Клик по вкладке Депозиты
        $$(byText("Депозиты")).find(visible).click();

//        Клик Архивные депозиты
        $(byLinkText("Архивные депозиты")).click();

//        Проверить, что в архивных депозитах отображается Максимальный доход при открытии до 31 января 2019
        $(".product-cell_big-jackpot").shouldHave(text("Максимальный доход при открытии до 31 января 2019"));

//        Проверить, что в архивных депозитах отображается Растущая процентная ставка
        $(".product-cell_deposit-premier.even").shouldHave(text("Растущая процентная ставка"));

//        Проверить, что в архивных депозиатх присутствует депозит Львиная доля
        $(byText("Львиная доля")).shouldBe(visible);
    }



@Test
void insuranceAlfaBankTest() {
// открывать сайт Альфа Банк
    open("https://alfabank.ru/");

//    Клик по Вклады
//    $((".p2vYszTaW"), 2).preceding(0).click();
//    $((".m2vYszTaW"), 1).parent().click();
    $((".n2vYszTaW"),1).closest(".p2vYszTaW").click();

// Найти на странице текст "Вклады и инвестиции"
    $("html").shouldHave(text("Вклады и инвестиции"));

//    Клик по Страхование вкладов
    $(".selected").sibling(4).click();

//    Найти на странице "Страхование вкладов"
    $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
}



    @Test
    void depositeAlfaBankTest() {
        // открывать сайт Альфа Банк
        open("https://alfabank.ru/");

        // Клик по "Вклады"
        $(byText("Вклады")).click();

        // Найти на странице текст "Вклады и инвестиции"
        $("html").shouldHave(text("Вклады и инвестиции"));

//       Поиск видимых элементов
        $$(byText("Депозиты")).find(visible).click();
//       $$(byText("Депозиты")).filter(visible).first().click();
//       $(byText("Депозиты"),1).click();

        // Найти на странице текст "Самый высокий доход"
        $(".product-cell__row_recharged:not(.disabled)").shouldHave(text("Самый высокий доход"));
//       $(".product-cell__row_recharged.col-xs-12").shouldHave(text("Самый высокий доход"));
    }



//       $("").parent(); - ищет верхний ближайщий элемент Родитель
//       $("").closest("h1"); - ищет вверх по дереву ближайший элемент с таким названием
//       $("").sibling(0); - ищет указанный элемент направо от необходимого
//       $("").preceding(1); - ищет указанный элемент налево от необходимого

//        div div - поиск первого заданного элемента в дереве
//        div>div - поиск первгого заданного child элемента

//        SelenideElement loginButton=$("div").preceding(0); - можно обозначать элементы, в таком коде поиск не происходит








}
