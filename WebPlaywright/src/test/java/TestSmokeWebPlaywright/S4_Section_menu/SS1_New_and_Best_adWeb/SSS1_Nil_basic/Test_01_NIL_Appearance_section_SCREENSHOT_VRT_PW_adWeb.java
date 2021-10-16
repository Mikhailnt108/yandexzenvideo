package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS1_Nil_basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_NIL_Appearance_section_SCREENSHOT_VRT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1. Appearance_section_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void appearanceSectionNilPage() throws IOException, InterruptedException{
        // Guest:
        niLPagePW.checkImageNilPageScrollGuest();
        niLPagePW.checkImageCherdakAndBannersGuest();
        niLPagePW.checkImageBlocksCollectionWidePageNil();
        niLPagePW.checkImageBlocksCollectionWithoutHeader();
        niLPagePW.checkImageFooterGuest();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        niLPagePW.checkImageNilPageScrollUser();
        niLPagePW.checkImageCherdakAndBannersUser();
        niLPagePW.checkImageBlocksCollectionWithHeaderUser();
        niLPagePW.checkImageFooterUser();
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
