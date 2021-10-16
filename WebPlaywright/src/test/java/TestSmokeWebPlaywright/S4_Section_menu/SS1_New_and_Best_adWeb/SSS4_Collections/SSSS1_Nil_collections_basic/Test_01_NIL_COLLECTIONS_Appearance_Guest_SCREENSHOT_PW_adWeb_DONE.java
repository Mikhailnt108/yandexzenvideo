package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS1_Nil_collections_basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_NIL_COLLECTIONS_Appearance_Guest_SCREENSHOT_PW_adWeb_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1. NIL_COLLECTIONS_Appearance_Guest_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_COLLECTIONS_Appearance_Guest() throws IOException, InterruptedException {
        // Guest:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.checkElementsCollection();
        niLPagePW.checkImageBlocksCollectionMinPageNilGuest();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.checkElementsCollection();
        niLPagePW.checkImageBlocksCollectionMediumPageNilGuest();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.checkElementsCollection();
        niLPagePW.checkImageBlocksCollectionWidePageNilGuest();
    }
}
