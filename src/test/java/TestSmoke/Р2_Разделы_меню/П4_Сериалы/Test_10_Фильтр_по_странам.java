package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_10_Фильтр_по_странам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Фильтр по странам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Disabled
    public void filterByCountry() {
        headerMenu.goToSerialsPage();
        serialsPage.clickOnCountryInput();
        serialsPage.checkCheckboxesInCountry();
        serialsPage.chooseOneCountry();
        serialsPage.checkRequestResultOneCountry();
        serialsPage.chooseTwoCountry();
        serialsPage.checkRequestResultTwoCountry();
    }
}
