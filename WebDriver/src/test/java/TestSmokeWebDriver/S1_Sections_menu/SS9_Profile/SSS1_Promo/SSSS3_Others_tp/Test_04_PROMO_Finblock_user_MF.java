package TestSmokeWebDriver.S1_Sections_menu.SS9_Profile.SSS1_Promo.SSSS3_Others_tp;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_PROMO_Finblock_user_MF extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Profile")
    @Story(value = "2. Promo")
    @DisplayName(value ="Finblock_user_MF")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542108")
    @Test
    @Tag("SuiteWD#4")
    public void financialBlockingMegafon() throws InterruptedException {
        headerMenu.goToFilmsPage();
        flowRegistration();
        headerMenu.openSubsectionPromo();
        promoPage.checkBlockingMegafon();
        promoPage.clickToButtonTopUpPhoneBalance();
        pageCMS.deleteAccountForBlockingMf("79267644248");
    }

    private void flowRegistration() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9267644248");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("79267644248", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdnBlockingMf("79267644248");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForBlockingMf();
    }
}
