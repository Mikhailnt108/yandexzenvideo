package TestSmoke.Р3_Профиль.П1_Акции.пп3_Остальные;

import base.TestBase;
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
    public void financialBlockingMegafon() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistration();
        headerMenu.openSubsectionPromo();
        promoPage.checkBlockingMegafon();
        promoPage.clickToButtonTopUpPhoneBalance();
        pageCMS.deleteAccountForBlockingMf();
    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9267644248");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("79267644248", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdnBlockingMf("79267644248");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForBlockingMf();
    }
}
