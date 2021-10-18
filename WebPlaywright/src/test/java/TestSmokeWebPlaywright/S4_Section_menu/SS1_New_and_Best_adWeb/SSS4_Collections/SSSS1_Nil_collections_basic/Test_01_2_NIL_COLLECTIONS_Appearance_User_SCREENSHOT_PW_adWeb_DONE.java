package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS1_Nil_collections_basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_2_NIL_COLLECTIONS_Appearance_User_SCREENSHOT_PW_adWeb_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "2. NIL_COLLECTIONS_Appearance_User_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_COLLECTIONS_Appearance_User() throws IOException, InterruptedException {

        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsCollection();
        nilPagePW.checkImageBlocksCollectionMinPageNilUser();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsCollection();
        nilPagePW.checkImageBlocksCollectionMediumPageNilUser();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsCollection();
        nilPagePW.checkImageBlocksCollectionWidePageNilUser();
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
