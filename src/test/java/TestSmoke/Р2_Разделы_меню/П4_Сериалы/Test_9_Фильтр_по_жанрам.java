package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_9_Фильтр_по_жанрам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "9. Фильтр по жанрам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void filterByGenre() {
        headerMenu.goToSerialsPage();
        serialsPage.clickOnGenreInput();
        serialsPage.checkCheckboxes();
        serialsPage.chooseOneGenre();
        serialsPage.checkRequestResultOneGenre();
        serialsPage.chooseTwoGenre();
        serialsPage.checkRequestResultTwoGenre();
    }
}
