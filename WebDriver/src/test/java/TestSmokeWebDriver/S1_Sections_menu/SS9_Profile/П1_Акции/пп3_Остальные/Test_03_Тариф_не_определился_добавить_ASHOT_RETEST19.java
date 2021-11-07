package TestSmokeWebDriver.S1_Sections_menu.SS9_Profile.П1_Акции.пп3_Остальные;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_Тариф_не_определился_добавить_ASHOT_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="Тариф не определился")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#4")
    public void tariffNotDefined() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseNotDefinedTariff("79260205027");
        headerMenu.closePopUpNotDefinedTariff();
        headerMenu.openSubsectionPromo();
        promoPage.checkNotDefinedTariff();
        pageCMS.chooseBundleCorpBezlimitFromMsisdn("79260205027");
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
