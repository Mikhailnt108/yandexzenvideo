package TestSmoke.Р2_Разделы_меню.П10_Поиск;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К1_Ничего_не_найдено extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Ничего не найдено")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void inputInvalidRequestInSearch(){
        headerMenu.goToNilPage();
        headerMenu.clickToSearchButton();
        headerMenu.checkOpenFieldSearch();
        headerMenu.inputInvalidRequestSearch();
        headerMenu.checkResponseOnInvalidSearch();
    }

}
