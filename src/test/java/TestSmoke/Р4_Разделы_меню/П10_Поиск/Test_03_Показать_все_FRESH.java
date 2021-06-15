package TestSmoke.Р4_Разделы_меню.П10_Поиск;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_Показать_все_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "10. Поиск")
    @DisplayName(value ="Показать все")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "106")
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
