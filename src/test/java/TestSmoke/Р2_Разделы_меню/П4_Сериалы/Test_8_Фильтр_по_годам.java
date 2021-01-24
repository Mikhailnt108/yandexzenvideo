package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_8_Фильтр_по_годам extends TestBase {
    @Test
    public void filterByYearSerials() {
        headerMenu.goToSerialsPage();
        serialsPage.clickOnYearInput();
        serialsPage.checkRadioButtons();
        serialsPage.chooseOneYearOnly();
        serialsPage.checkRequestResultOneYearOnly();
        serialsPage.choosePeriodOfYears();
        serialsPage.checkRequestResultPeriodOfYears();
    }

}
