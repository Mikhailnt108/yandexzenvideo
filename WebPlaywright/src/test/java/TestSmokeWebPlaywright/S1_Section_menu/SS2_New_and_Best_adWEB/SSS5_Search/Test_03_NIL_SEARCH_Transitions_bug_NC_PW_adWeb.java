package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS5_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_NIL_SEARCH_Transitions_bug_NC_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. SEARCH_Transitions")
    @Severity(SeverityLevel.BLOCKER)
//    @TmsLink("53962593")
    @Test
    @Tag("adWebSuitePW#1")
    public void SEARCH_Transitions(){
        headerMenuPW.goToNilPage();
        nilPagePW.checkInputMultipleSimbolsInSearchForm();
        nilPagePW.checkClickOnFilmFromResultSearch();
        nilPagePW.checkClickOnSerialFromResultSearch();
        nilPagePW.checkClickOnTvProgramFromResultSearch();
        // проверить есть ли в выдаче поиска тв каналы
    }
}
