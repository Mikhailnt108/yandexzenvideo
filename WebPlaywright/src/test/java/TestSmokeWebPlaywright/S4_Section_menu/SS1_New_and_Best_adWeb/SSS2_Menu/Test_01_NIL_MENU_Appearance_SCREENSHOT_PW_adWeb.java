package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS2_Menu;

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
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_NIL_MENU_Appearance_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1. MENU_Appearance_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void MENU_Appearance() throws IOException, InterruptedException {
        // Guest:
        // Min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsMenuMinPageNilGuest();
        nilPagePW.checkImageMenuMinPageNilGuest();
        nilPagePW.openBlockMenuMegaFonAndCheckImageMinPageNil();
        nilPagePW.openBlockMenuMftvAndCheckImageMinPageNilGuest();
        // Medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsMenuMediumPageNilGuest();
        nilPagePW.checkImageMenuMediumPageNilGuest();
        nilPagePW.openBlockMenuMegaFonAndCheckImageMediumPageNilGuest();
        nilPagePW.openBlockMenuMftvAndCheckImageMediumPageNilGuest();
        // Wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkImageMenuWidePageNilGuest();
        // User:
        // Min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        flowRegistation();
//        flowAutorization();
        Thread.sleep(5000);
        nilPagePW.checkElementsMenuMinPageNilUser();
        nilPagePW.checkImageMenuMinPageNilUser();
        nilPagePW.openBlockMenuMegaFonMinPageNilUser();
        nilPagePW.openBlockMenuMftvMinPageNilUser();
        nilPagePW.openBlockMenuProfileMinPageNil();
        // Medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsMenuMediumPageNilUser();
//        flowAutorization();// пропадает логин
        nilPagePW.checkImageMenuMediumPageNilUser();
        nilPagePW.openBlockMenuMegaFonMediumPageNilUser();
        nilPagePW.openBlockMenuMftvMediumPageNilUser();
        nilPagePW.openBlockMenuProfileMediumPageNil();
        // Wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
//        flowAutorization();// пропадает логин
        nilPagePW.checkImageMenuWidePageNilUser();
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
