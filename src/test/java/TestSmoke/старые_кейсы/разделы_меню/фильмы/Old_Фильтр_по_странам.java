package TestSmoke.старые_кейсы.разделы_меню.фильмы;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Old_Фильтр_по_странам extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Фильтр по странам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void filterByCountry() throws InterruptedException {
        headerMenu.goToFilmsPage();
        filmsPage.clickOnCountryInput();
        filmsPage.checkCheckboxesInCountry();
        filmsPage.chooseOneCountry();
        filmsPage.checkRequestResultOneCountry();
        filmsPage.chooseTwoCountry();
        filmsPage.checkRequestResultTwoCountry();
    }
}
