package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS6_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test_04_NIL_SEARCH_All_results_bug_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "4. SEARCH_All_results")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void SEARCH_All_results(){
        headerMenuPW.goToNilPage();
        nilPagePW.checkInputMultipleSimbolsInSearchForm();
        nilPagePW.clickOnButtonAllResultsInSearch();
        headerMenuPW.goToNilPage();
        nilPagePW.checkInputMultipleSimbolsInSearchForm();
        nilPagePW.pressEnterOnAllResultsInSearchForm();
    }
}
