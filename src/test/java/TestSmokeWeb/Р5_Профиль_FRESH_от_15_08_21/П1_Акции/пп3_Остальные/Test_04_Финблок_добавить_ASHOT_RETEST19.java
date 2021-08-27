package TestSmokeWeb.Р5_Профиль_FRESH_от_15_08_21.П1_Акции.пп3_Остальные;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_Финблок_добавить_ASHOT_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="4. Финблок юзер МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void financialBlockingMegafon() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistration();
        headerMenu.openSubsectionPromo();
        promoPage.checkBlockingMegafon();
        promoPage.clickToButtonTopUpPhoneBalance();
        pageCMS.deleteAccountForBlockingMf("79267644248");
    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9267644248");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("79267644248", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdnBlockingMf("79267644248");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForBlockingMf();
    }
}
