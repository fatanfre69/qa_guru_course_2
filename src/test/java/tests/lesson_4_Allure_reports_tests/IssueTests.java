package tests.lesson_4_Allure_reports_tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import qaguru.*;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;

@Owner("aakulikoff")
@Feature("Работа с задачами")

class IssueTests extends TestData {

    private static final String ISSUE = "qagurutest";
    private static final String REPOSITORY = "fatanfre69/test_for_qaguru";
    private static final String BASE_URL = "https://github.com";

    private final BasicSteps webSteps = new BasicSteps();

    private final ApiSteps apiSteps = new ApiSteps();

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
//        SelenideLogger.addListener("allure", new LogEventListener() {
//            @Override
//            public void afterEvent(LogEvent currentLog) {
//                System.out.printf("Stop %s%n", currentLog.toString());
//            }
//
//            @Override
//            public void beforeEvent(LogEvent currentLog) {
//                System.out.printf("Start %s%n", currentLog.toString());
//            }
//        });
    }


    @Test
    @DisplayName("Создание Issue в репозитории без использования шагов")
    public void addIssueInRepositoryWithNoSteps() {
        parameter("Репозиторий", REPOSITORY);
        link("https://github.com/" + REPOSITORY);

        open(BASE_URL);
        $(By.linkText("Sign in")).click();
        $("#login_field").setValue(DEFAULT_LOGIN);
        $("#password").setValue(DEFAULT_PASSWORD).pressEnter();
        $(By.linkText("New")).click();
        $(".js-repo-name").setValue(DEFAULT_REPOSITORY_NAME);
        $("html").shouldHave(text(DEFAULT_REPOSITORY_NAME + " is available"));
        $(".btn.btn-primary.first-in-line").click();
        $(byText("Issues"), 1).click();
        $((".btn.btn-primary"),1).click();
        $("#issue_title").setValue("qagurutest").pressEnter();

        $((".avatar-user"),1).click();
        $(".logout-form").click();

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(By.linkText("fatanfre69/test_for_qaguru")).click();
        $(byText("Issues")).click();
        $(withText(ISSUE)).should(Condition.exist);
    }


    @Test
    @DisplayName("Создание Issue в репозитории с использованием шагов")
    public void addIssueInRepositoryWithSteps() {
        parameter("Репозиторий", REPOSITORY);
        link("https://github.com/" + REPOSITORY);

        step("Авторизация", ()-> {
            step("Открываем главную страницу", () ->
                open(BASE_URL));
            step("Клик \"Sign in\"", ()->
                $(By.linkText("Sign in")).click());
            step("Ввести логин", ()->
                $("#login_field").setValue(DEFAULT_LOGIN));
            step("Ввести пароль", ()->
                $("#password").setValue(DEFAULT_PASSWORD).pressEnter());
        });
        step("Создать новый репозиторий", ()-> {
            step("Клик \"New\"", ()->
                $(By.linkText("New")).click());
            step("Задать имя репозитория", ()->
                $(".js-repo-name").setValue(DEFAULT_REPOSITORY_NAME));
            step("Проверить, что имя сводобно", ()->
                $("html").shouldHave(text(DEFAULT_REPOSITORY_NAME + " is available")));
            step("Создать репозиторий", ()->
                $(".btn.btn-primary.first-in-line").click());
        });

        step("Создать Issue", ()-> {
            step("Клик Issues", ()->
                $(byText("Issues"), 1).click());
            step("Клик New issues", ()->
                $((".btn.btn-primary"),1).click());
            step("Веести название и создать Issue", ()->
                $("#issue_title").setValue("qagurutest").pressEnter());
        });

        step("Выйти из аккаунта", ()-> {
            step("Клик на аватар", ()->
                $((".avatar-user"),1).click());
            step("Клик выйти", ()->
                $(".logout-form").click());
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            step("Клик поисковая строка", ()->
                $(".header-search-input").click());
            step("Ввести название репозитория", ()->
                $(".header-search-input").sendKeys(REPOSITORY));
            step("Произвести описк по введенным данным", ()->
                $(".header-search-input").submit());
        });

        step("Переходим по ссылке репозитория " + REPOSITORY, () ->
            $(By.linkText("fatanfre69/test_for_qaguru")).click());

        step("Открываем страницу с задачами", () ->
            $(byText("Issues")).click());

        step("Проверяем наличие задачи" + ISSUE, () ->
            $(withText(ISSUE)).should(Condition.exist));
    }


    @Test
    @DisplayName("Создание Issue в репозитории")
    public void addIssueInRepositoryWithAnnotationSteps() {
        parameter("Репозиторий", REPOSITORY);
        link("https://github.com/" + REPOSITORY);

        webSteps.openMainPage();
        webSteps.clickSignIn();
        webSteps.setLogin();
        webSteps.setPassword();
        webSteps.clickNew();
        webSteps.setRepositoryName();
        webSteps.checkRepositoryName();
        webSteps.createRepository();
        webSteps.clickIssues();
        webSteps.clickNewIssues();
        webSteps.setIssueName();
        webSteps.clickAvatar();
        webSteps.logOut();
        webSteps.clickSearch();
        webSteps.typeIssueName();
        webSteps.searchIssue();
        webSteps.clickRepositoryName();
        webSteps.openIssuePage();
        webSteps.checkIssueName();
    }


}

