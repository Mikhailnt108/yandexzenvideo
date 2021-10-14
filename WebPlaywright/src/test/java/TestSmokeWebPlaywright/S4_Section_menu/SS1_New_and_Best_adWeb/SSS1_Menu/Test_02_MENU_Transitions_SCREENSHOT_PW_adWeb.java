package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS1_Menu;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_02_MENU_Transitions_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "2. MENU_Transitions_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void MENU_Transitions() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        niLPagePW.goToTabsHeaderMenuMftvGuest();
         promocode:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.choosePromoCodeAndCheckImageMinPageNilGuest();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.choosePromoCodeAndCheckImageMediumPageNilGuest();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.choosePromoCodeAndCheckImageWidePageNilGuest();
        // search:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.chooseSearchAndCheckImageMinPageGuest();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.chooseSearchAndCheckImageMediumPageGuest();
        // wibe:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.chooseSearchAndCheckImageWibePageGuest();

        niLPagePW.clickOnEnterButtonAndCheckImage();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        flowAutorization();// пропадает логин
        niLPagePW.goToTabsHeaderMenuMftvUser();
        // promocode:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.choosePromoCodeAndCheckImageMinPageNilUser();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.choosePromoCodeAndCheckImageMediumPageNilUser();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.choosePromoCodeAndCheckImageWidePageNilUser();
        // search:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.chooseSearchAndCheckImageMinPageUser();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.chooseSearchAndCheckImageMediumPageUser();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        niLPagePW.chooseSearchAndCheckImageWidePageUser();
        // profile:
        niLPagePW.goToSectionsProfileMenu();
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
