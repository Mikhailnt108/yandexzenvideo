package TestSmoke.Р2_Разделы_меню.П10_Поиск;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class К1_Ничего_не_найдено extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "10. Поиск")
    @DisplayName(value ="Ничего не найдено")
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
