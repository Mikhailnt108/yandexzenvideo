package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS6_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test_03_NIL_SEARCH_Transitions_bug_NC_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "3. SEARCH_Transitions")
    @Severity(SeverityLevel.BLOCKER)
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
