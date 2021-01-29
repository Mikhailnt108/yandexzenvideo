package TestSmoke.Р2_Разделы_меню.П10_Поиск;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К3_Показать_все extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Показать все")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void inputInvalidRequestInSearch(){
        headerMenu.goToNilPage();
        headerMenu.clickToSearchButton();
        headerMenu.checkOpenFieldSearch();
        headerMenu.inputValidRequestSearch();
        headerMenu.checkResponseOnValidSearch();
        headerMenu.clickToLinkShowAll();
        resultsSearchPage.checkOpenResultsSearchPage();
    }
}
