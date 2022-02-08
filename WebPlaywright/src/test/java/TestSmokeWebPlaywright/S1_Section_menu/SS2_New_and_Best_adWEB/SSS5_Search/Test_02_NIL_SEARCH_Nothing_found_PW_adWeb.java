package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS5_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_SEARCH_Nothing_found_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. SEARCH_Nothing_found")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("53962592")
    @Test
    @Tag("Grid")
    public void SEARCH_Nothing_found(){
        headerMenuPW.goToNilPage();
        nilPagePW.checkResultSearchNothingFound();
    }
}
