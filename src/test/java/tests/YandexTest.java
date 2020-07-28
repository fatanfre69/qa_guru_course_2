package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

  @Test
    void googleSearchTest(){
//      открыть Yandex
      open("https://yandex.ru");

//      ввести в поиск Google
      $("#text").val("Google").pressEnter();

//      проверить, что Google есть в результате поиска
      $("html").shouldBe(Condition.text("Google — поисковая система"));

  }


}
