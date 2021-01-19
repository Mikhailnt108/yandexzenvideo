package Smoke.Р2_Разделы_меню.П3_Фильмы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К13_Фильтр_по_странам extends TestBase {
    @Test
    public void filterByCountry() {
        headerMenu.goToFilmsPage();
        filmsPage.clickOnCountryInput();
        filmsPage.checkCheckboxesInCountry();
        filmsPage.chooseOneCountry();
        filmsPage.checkRequestResultOneCountry();
        filmsPage.chooseTwoCountry();
        filmsPage.checkRequestResultTwoCountry();
    }
}
