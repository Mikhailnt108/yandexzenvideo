package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_8_Фильтр_по_годам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "8. Фильтр по годам")
    @Severity(SeverityLevel.BLOCKER)
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
