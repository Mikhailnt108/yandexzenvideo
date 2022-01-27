package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS5_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_NIL_SEARCH_Correct_request_bug_NC_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1. SEARCH_Correct_request")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542006")
    @Test
    @Tag("adWebSuitePW#1")
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
