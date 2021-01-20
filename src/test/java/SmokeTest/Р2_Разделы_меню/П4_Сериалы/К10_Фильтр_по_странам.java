package SmokeTest.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К10_Фильтр_по_странам extends TestBase {
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
