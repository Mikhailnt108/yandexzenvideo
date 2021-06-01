package TestSmoke.старые_кейсы.разделы_меню.сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_Фильтр_по_жанрам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Фильтр по жанрам")
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
