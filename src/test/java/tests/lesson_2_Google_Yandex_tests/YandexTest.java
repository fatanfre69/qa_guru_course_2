package tests.lesson_2_Google_Yandex_tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

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


@Test
  void mailYandexSendTest() {
//      открыть Yandex
      open("https://yandex.ru");

//      Клик Войти в почтe
      $(byLinkText("Войти в почту")).click();

//      Ввести Логин, клик Войти
      switchTo().window(1);
      $("[autocomplete='username']").setValue("meshtestsudir").pressEnter();

//      Ввести Пароль, клик Войти
      $(byName("passwd")).setValue("Sudir123").pressEnter();

//      Проверить отображение логина
      $(".user-account__name").shouldBe(Condition.visible).shouldHave(Condition.text("meshtestsudir"));

//      Клик Написать
      $(byTitle("Написать (w, c)")).click();

//      Заполнить поле Кому
      $(".composeYabbles").setValue("0987654321mailnomailno1234567890@mail.ru");

//      Заполнить поле Тема
      $(".composeTextField ").setValue("нет темы");

//      Заполнить тело письма
      $("#cke_1_contents").click();
      $(getFocusedElement()).setValue("test");

//      Клик отправить
      $(".ComposeControlPanelButton-Button_action").click();

//      Проверить, что письмо отправилось
      $(".ComposeDoneScreen-Header").shouldHave(Condition.text("Письмо отправлено"));
}



@Test
    void translateYandexTest(){
//      открыть Yandex
    open("https://yandex.ru");

//    Ввести в поиск слово переводчик
    $("#text").val("Переводчик");

//    Клик Поиск
    $(".search2__button").click();

//    Ввести в колдунщике текст no money no honey и перевести
    $(".Textarea-Control").click();
    $(getFocusedElement()).setValue("no money no honey").pressEnter();

//    Поменять языки местами
    $(".Translate-ReverseButton").click();

//    Клик на выбор языка ввода
    $(".Translate-Select").click();
}


}
