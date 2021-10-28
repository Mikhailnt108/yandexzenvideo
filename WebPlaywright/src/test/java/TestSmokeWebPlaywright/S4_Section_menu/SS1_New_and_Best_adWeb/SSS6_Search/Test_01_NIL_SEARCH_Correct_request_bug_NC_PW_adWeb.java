package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS6_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_NIL_SEARCH_Correct_request_bug_NC_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1. SEARCH_Correct_request")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void SEARCH_Correct_request() throws IOException, InterruptedException {
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageMinPageGuest();
        nilPagePW.checkElementsSearchFormForMinPage();
        nilPagePW.checkCloseSearchFormMinPage();

        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageMediumPageGuest();
        nilPagePW.checkElementsSearchFormForMediumPage();
        nilPagePW.checkCloseSearchFormMediumPage();

        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageWidePageGuest();
        nilPagePW.checkElementsSearchFormForWidePage();
        nilPagePW.checkCloseSearchFormWidePage();

        // checkSearch:
        nilPagePW.checkInputOneSimbolInSearchForm();
        nilPagePW.checkInputMultipleSimbolsInSearchForm();
        // добавить проверку про не более 2-х пунктов
    }
}
