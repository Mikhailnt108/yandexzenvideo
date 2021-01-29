package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_10_Фильтр_по_странам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "10. Фильтр по странам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
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
