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
public class Test_01_NIL_MENU_Appearance_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1. MENU_Appearance_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void MENU_Appearance() throws IOException, InterruptedException {
        // Guest:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsMenuAphonePageNilGuest();
        nilPagePW.checkImageMenuAphonePageNilGuestMWEB();
        nilPagePW.openBlockMenuMegaFonAndCheckImagePageNilMWEB();
        nilPagePW.openBlockMenuMftvAndCheckImageAphonePageNilGuestMWEB();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsMenuApadPageNilGuest();
        nilPagePW.checkImageMenuApadPageNilGuestMWEB();
        nilPagePW.openBlockMenuMegaFonAndCheckImageApadPageNilGuestMWEB();
        nilPagePW.openBlockMenuMftvAndCheckImageApadPageNilGuestMWEB();
//        // Wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.checkImageMenuWidePageNilGuest();
        // User:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        flowRegistation();
        Thread.sleep(5000);
        nilPagePW.checkElementsMenuAphonePageNilUser();
        nilPagePW.checkImageMenuAphonePageNilUserMWEB();
        nilPagePW.openBlockMenuMegaFonAphonePageNilUser();
        nilPagePW.openBlockMenuMftvAphonePageNilUser();
        nilPagePW.openBlockMenuProfileAphonePageNil();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsMenuApadPageNilUser();
        nilPagePW.checkImageMenuApadPageNilUserMWEB();
        nilPagePW.openBlockMenuMegaFonApadPageNilUserMWEB();
        nilPagePW.openBlockMenuMftvApadPageNilUserMWEB();
        nilPagePW.openBlockMenuProfileApadPageNilMWEB();
//        // Wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.checkImageMenuWidePageNilUser();
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
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
