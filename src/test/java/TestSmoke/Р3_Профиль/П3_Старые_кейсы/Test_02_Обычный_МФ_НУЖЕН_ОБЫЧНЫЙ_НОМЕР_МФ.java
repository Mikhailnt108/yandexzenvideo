package TestSmoke.Р3_Профиль.П3_Старые_кейсы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Обычный_МФ_НУЖЕН_ОБЫЧНЫЙ_НОМЕР_МФ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @DisplayName(value ="Обычный МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userMegafon() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistration();
        pageCMS.chooseBundleOsnovnoyFromMsisdn("79260192144");
        headerMenu.openSubsectionPromo();
        promoPage.checkBundleOsnovnoy();
        pageCMS.deleteAccountMF();

    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpCreatePassword.checkOpenFrameCreatePassword();
        popUpCreatePassword.inputPassword("111111");
        popUpCreatePassword.clickToComeIn("Войти");
        popUpInputCod.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        popUpInputCod.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
