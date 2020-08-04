package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTests {

    @Test
    void alfabankDepositeTest() {
       open("https://alfabank.ru/");
       $(byText("Вклады")).click();
       $("html").shouldHave(text("Вклады и инвестиции"));
//       Поиск видимых элементов
       $$(byText("Депозиты")).find(visible).click();
//       $$(byText("Депозиты")).filter(visible).first().click();
//       $(byText("Депозиты"),1).click();
       $(".product-cell__row_recharged:not(.disabled)").shouldHave(text("Самый высокий доход"));
//       $(".product-cell__row_recharged.col-xs-12").shouldHave(text("Самый высокий доход"));





//       $("").parent(); - ищет верхний ближайщий элемент Родитель
//       $("").closest("h1"); - ищет вверх по дереву ближайший элемент с таким названием
//       $("").sibling(0); - ищет указанный элемент направо от необходимого
//       $("").preceding(1); - ищет указанный элемент налево от необходимого

//        div div - поиск первого заданного элемента в дереве
//        div>div - поиск первгого заданного child элемента

//        SelenideElement loginButton=$("div").preceding(0); - можно обозначать элементы, в таком коде поиск не происходит




    }






}
