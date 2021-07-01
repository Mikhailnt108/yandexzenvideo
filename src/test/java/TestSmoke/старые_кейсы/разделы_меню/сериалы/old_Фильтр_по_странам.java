package TestSmoke.старые_кейсы.разделы_меню.сериалы;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_Фильтр_по_странам extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Фильтр по странам")
    @Severity(SeverityLevel.BLOCKER)
    @Test

    public void filterByCountry() throws InterruptedException {
        headerMenu.goToSerialsPage();
        serialsPage.clickOnCountryInput();
        serialsPage.checkCheckboxesInCountry();
        serialsPage.chooseOneCountry();
        serialsPage.checkRequestResultOneCountry();
        serialsPage.chooseTwoCountry();
        serialsPage.checkRequestResultTwoCountry();
    }
}
