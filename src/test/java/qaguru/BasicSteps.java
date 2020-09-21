package qaguru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class BasicSteps {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "fatanfre69/test_for_qaguru";
    private static final String ISSUE = "qagurutest";

    @Step("Открываем главную страницу")
    public void openMainPage () {
        open(BASE_URL);
    }

    @Step("Клик \"Sign in\"")
    public void clickSignIn () {
        $(By.linkText("Sign in")).click();
    }

    @Step("Ввести логин")
    public void setLogin () {$("#login_field").setValue(DEFAULT_LOGIN);}

    @Step("Ввести пароль")
    public void setPassword () {
        $("#password").setValue(DEFAULT_PASSWORD).pressEnter();
    }

    @Step("Клик \"New\"")
    public void clickNew () {
        $(By.linkText("New")).click();
    }

    @Step("Задать имя репозитория")
    public void setRepositoryName () {$(".js-repo-name").setValue(DEFAULT_REPOSITORY_NAME); }

    @Step("Проверить, что имя сводобно")
    public void checkRepositoryName () {
        $("html").shouldHave(text(DEFAULT_REPOSITORY_NAME + " is available"));
    }

    @Step("Создать репозиторий")
    public void createRepository () {
        $(".btn.btn-primary.first-in-line").click();
    }

    @Step("клик Issues")
    public void clickIssues () {$(byText("Issues"), 1).click();}

    @Step ("Клик New issues")
    public void clickNewIssues () {$((".btn.btn-primary"),1).click();}

    @Step ("Веести название и создать Issue")
    public void setIssueName () {$("#issue_title").setValue("qagurutest").pressEnter();}

    @Step ("Клик на аватар")
    public void clickAvatar () {$((".avatar-user"),1).click();}

    @Step ("Клик выйти")
    public void logOut () {$(".logout-form").click();}

    @Step ("Клик поисковая строка")
    public void clickSearch () {$(".header-search-input").click();}

    @Step ("Ввести название репозитория")
    public void typeIssueName () {$(".header-search-input").sendKeys(REPOSITORY);}

    @Step ("Произвести описк по введенным данным")
    public void searchIssue () {$(".header-search-input").submit();}

    @Step ("Переходим по ссылке репозитория")
    public void clickRepositoryName () {$(By.linkText("fatanfre69/test_for_qaguru")).click();}

    @Step ("Открываем страницу с задачами")
    public void openIssuePage () {$(byText("Issues")).click();}

    @Step ("Проверяем наличие задачи")
    public void checkIssueName () {$(withText(ISSUE)).should(Condition.exist);}

    @Step("Ищем репозиторий")
    public void searchForRepository(final String name) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(name);
        $(".header-search-input").submit();
    }

    @Step("Переходим по ссылке репозитория")
    public void openReposirtoryByLink(final String name) {
        $(By.linkText(name)).click();
    }

}
