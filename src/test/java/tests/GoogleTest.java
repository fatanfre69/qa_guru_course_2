package tests;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomString;


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
        String searchText = "ru.usembassy.gov";
//        Открыть Google
        open("https://google.com");

//        Ввести "visa USA"
        $(byTitle("Поиск")).setValue("visa USA");

//        Клик по Поиску
        $(byName("btnK")).click();

//        Проверить, что visa USA появился в результате поиска
        $("body").shouldHave(text(searchText));
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




    @Test
    @Description("Регистарция акканута Google с несовпадающими паролями")
    void registrationGoogleGmail() {
        String randomString = getRandomString(15);
        int randomInt = getRandomInt(22, 100);

//        Открыть Google
        open("https://google.com");

//        Клик Почта
        $(byLinkText("Почта")).click();

//        Клик Создать аккаунт
        $(byLinkText("Создать аккаунт")).click();
        switchTo().window(1);

//        Заполнить поле Имя
        $("#firstName").setValue("Имя");

//        Заполнить поле Фамилия
        $("#lastName").setValue("Фамилия");

//        Заполнить поле Имя пользователя
        $("#username").setValue(randomString);

//        Заполнить поле Пароль
        $("[name='Passwd']").setValue(randomInt + "1");

//        Заполнить поле Подтверждение пароля
        $("[name='ConfirmPasswd']").setValue(randomInt + "2");

//        Клик Далее
        $(byText("Далее")).click();

//        Появляется сообщение "Пароли не совпадают. Повторите попытку"
       $("html").shouldHave(text("Пароли не совпадают. Повторите попытку"));
    }



    @Test
    @Description("Поиск сайта Petshop в Google и добавление второго по счета товара в корзину и открытие формы оформления заказа")
    void putItemInBasket() {
//        Открыть Google
        open("https://google.com");

//        Ввести "магазин для животных Петшоп"
        $(byName("q")).setValue("магазин для животных Петшоп").pressEnter();

//        Проверить, что в результате поиска есть магазин petshop и кдик по нему
        $("body").$(byText("www.petshop.ru")).click();

//        Поиск корма для кошек
        $(".MuiInputBase-input").setValue("корм для кошек").pressEnter();

//        Клик по второму выданному результату
        $(By.xpath("//div[@id='products-wrapper']//li[@data-position='2']")).click();

//        Добавить товар в корзину
        $(byText("Добавить в корзину")).click();
        sleep(10000);

//        Перейти в корзину
        $(byTitle("Корзина")).click();

//        Если товар последний, то переход к офомлению заказа
        if($(".CartItem_cartItem_exist__1iUZy").has(text("Последний")))
        {
            //        Увеличить кол-во товара в корзине вручную, задав число самому
            $(".QuantityCounter_input__19Md_").click();
            $(getFocusedElement()).setValue("11");

            //        Уменьшить кол-во товар в корзине на 3, кликая на значок -
            $(".QuantityCounter_btn_minus__vrIsA").click();
            $(".QuantityCounter_btn_minus__vrIsA").click();
            $(".QuantityCounter_btn_minus__vrIsA").click();
        }

//        Клик Оформить заказ
        $(byText("Оформить заказ")).click();
        $(byText("Оформить заказ")).click();
    }



    @Test
    void youTubeTest() {
//        Открыть Google
        open("https://google.com");

//        Ввести "YouTube"
        $(byName("q")).setValue("YouTube").pressEnter();

//        Открыть сайт YouTube
        $("body").$(byText("www.youtube.com")).click();

//        Ввести в поиске Рецепт плова
        $("#search-form").click();
        $(getFocusedElement()).setValue("Рецепт плова").pressEnter();

//        Клик фильтр
        $(byLinkText("ФИЛЬТРЫ")).click();

//        Выбрать фильтр по Числу просмотров
        $(byLinkText("По числу просмотров")).click();

//        Клик второй элемент
        $$(byText("Плов")).get(2).click();
    }
}


