package S8_Search;

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
    @Test
    @Tag("adWebSuitePW#1")
    public void SEARCH_Correct_request() throws IOException, InterruptedException {
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageAphonePageGuestMWEB();
        nilPagePW.checkElementsSearchFormForAphonePage();
        nilPagePW.checkCloseSearchFormAphonePage();

        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageApadPageGuestMWEB();
        nilPagePW.checkElementsSearchFormForApadPage();
        nilPagePW.checkCloseSearchFormApadPage();

        // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.chooseSearchAndCheckImageWidePageGuest();
//        nilPagePW.checkElementsSearchFormForWidePage();
//        nilPagePW.checkCloseSearchFormWidePage();

        // checkSearch:
        nilPagePW.checkInputOneSimbolInSearchForm();
        nilPagePW.checkInputMultipleSimbolsInSearchForm();
        // добавить проверку про не более 2-х пунктов
    }
}