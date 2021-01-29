package TestSmoke.Р2_Разделы_меню.П10_Поиск;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К2_Предварительные_результаты_поиска extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Предварительные результаты поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void inputInvalidRequestInSearch(){
        headerMenu.goToNilPage();
        headerMenu.clickToSearchButton();
        headerMenu.checkOpenFieldSearch();
        headerMenu.inputValidRequestSearch();
        headerMenu.checkResponseOnValidSearch();
    }
}
