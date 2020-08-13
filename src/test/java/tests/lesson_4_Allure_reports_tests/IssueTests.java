package tests.lesson_4_Allure_reports_tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

@Owner("aakulikoff")
@Feature("Работа с задачами")

public class IssueTests {

    private static final String REPOSITORY = "aakulikoff/lesson_4_Allure_reports_tests";

    @Test
    @DisplayName("Создание Issue в репозитории")
    public void addIssueInRepository() {
        parameter("Репозиторий", REPOSITORY);
        link("https://github.com/" + REPOSITORY);

        step("Открываем главную страницу", ()->
            open("https://github.com"));


    }



}
