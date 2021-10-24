package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS6_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test_02_SEARCH_Nothing_found_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "2. SEARCH_Nothing_found")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void SEARCH_Nothing_found(){
        headerMenuPW.goToNilPage();
        nilPagePW.checkResultSearchNothingFound();
    }
}
