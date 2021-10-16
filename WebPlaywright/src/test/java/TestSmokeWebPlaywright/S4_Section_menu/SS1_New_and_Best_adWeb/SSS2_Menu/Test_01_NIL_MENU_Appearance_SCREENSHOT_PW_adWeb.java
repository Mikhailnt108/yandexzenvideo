package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS2_Menu;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        niLPagePW.checkElementsMenuMinPageNilGuest();
        niLPagePW.checkImageMenuMinPageNilGuest();
        niLPagePW.openBlockMenuMegaFonAndCheckImageMinPageNil();
        niLPagePW.openBlockMenuMftvAndCheckImageMinPageNilGuest();
        // Medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.checkElementsMenuMediumPageNilGuest();
        niLPagePW.checkImageMenuMediumPageNilGuest();
        niLPagePW.openBlockMenuMegaFonAndCheckImageMediumPageNilGuest();
        niLPagePW.openBlockMenuMftvAndCheckImageMediumPageNilGuest();
        // Wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.checkImageMenuWidePageNilGuest();
        // User:
        // Min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        flowRegistation();
        flowAutorization();
        Thread.sleep(5000);
        niLPagePW.checkElementsMenuMinPageNilUser();
        niLPagePW.checkImageMenuMinPageNilUser();
        niLPagePW.openBlockMenuMegaFonMinPageNilUser();
        niLPagePW.openBlockMenuMftvMinPageNilUser();
        niLPagePW.openBlockMenuProfileMinPageNil();
        // Medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.checkElementsMenuMediumPageNilUser();
        flowAutorization();// пропадает логин
        niLPagePW.checkImageMenuMediumPageNilUser();
        niLPagePW.openBlockMenuMegaFonMediumPageNilUser();
        niLPagePW.openBlockMenuMftvMediumPageNilUser();
        niLPagePW.openBlockMenuProfileMediumPageNil();
        // Wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        flowAutorization();// пропадает логин
        niLPagePW.checkImageMenuWidePageNilUser();
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
    private void flowAutorization() {
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.inputPasswordAutorization("111111");
        headerMenuPW.clickToComeIn("Войти");
    }
}
