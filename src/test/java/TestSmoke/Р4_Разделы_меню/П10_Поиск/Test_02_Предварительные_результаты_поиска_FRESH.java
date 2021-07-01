package TestSmoke.Р4_Разделы_меню.П10_Поиск;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Предварительные_результаты_поиска_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "10. Поиск")
    @DisplayName(value ="Предварительные результаты поиска")
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
