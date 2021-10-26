package TestSmokeWebPlaywright.S4_Section_menu.П10_Промокод;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_Общий_вид_окна_Ввести_промокод_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "11. Промокод")
    @DisplayName(value ="1. Общий вид окна Ввести_промокод (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3")
    public void checkViewOfPromoCodePopUp() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToButtonPromo();
        flowRegistationMF();
        headerMenuPW.clickToButtonPromo();
        headerMenuPW.checkOpenPopUpPromoCode();
        headerMenuPW.checkElementsPopUpPromoCode();
        headerMenuPW.checkImagePopUpPromoCode();
    }
    private void flowRegistationMF() {
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
