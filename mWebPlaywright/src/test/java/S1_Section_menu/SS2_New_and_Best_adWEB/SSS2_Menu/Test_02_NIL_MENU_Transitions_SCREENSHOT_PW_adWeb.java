package S1_Section_menu.SS2_New_and_Best_adWEB.SSS2_Menu;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_MENU_Transitions_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. MENU_Transitions_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void MENU_Transitions() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.goToTabsHeaderMenuMftvGuest();
        // promocode:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.choosePromoCodeAndCheckImageAphonePageNilGuestMWEB();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.choosePromoCodeAndCheckImageApadPageNilGuestMWEB();
        // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.choosePromoCodeAndCheckImageWidePageNilGuest();
        // search:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageAphonePageGuestMWEB();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageApadPageGuestMWEB();
        // wibe:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.chooseSearchAndCheckImageWibePageGuest();

        nilPagePW.clickOnEnterButtonAndCheckImageMWEB();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.goToTabsHeaderMenuMftvUser();
        // promocode:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.choosePromoCodeAndCheckImageAphonePageNilUserMWEB();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.choosePromoCodeAndCheckImageApadPageNilUserMWEB();
        // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.choosePromoCodeAndCheckImageWidePageNilUser();
        // search:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageAphonePageUserMWEB();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.chooseSearchAndCheckImageApadPageUserMWEB();
        // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.chooseSearchAndCheckImageWidePageUser();
        // profile:
        nilPagePW.goToSectionsProfileMenu();
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdmWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdWeb("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
