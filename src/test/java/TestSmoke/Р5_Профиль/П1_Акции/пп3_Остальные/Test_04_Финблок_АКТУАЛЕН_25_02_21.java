package TestSmoke.Р5_Профиль.П1_Акции.пп3_Остальные;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_Финблок_АКТУАЛЕН_25_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="Финблок юзер МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "124")
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
