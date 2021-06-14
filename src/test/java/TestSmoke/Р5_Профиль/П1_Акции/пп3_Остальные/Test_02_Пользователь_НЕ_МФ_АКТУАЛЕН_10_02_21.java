package TestSmoke.Р5_Профиль.П1_Акции.пп3_Остальные;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Пользователь_НЕ_МФ_АКТУАЛЕН_10_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @DisplayName(value ="Пользователь НЕ_МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userNotMegafon() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistration();
        headerMenu.openSubsectionPromo();
        promoPage.checkNotMegafon();
        promoPage.clickToButtonGoOver();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9261184972");
        popUpInputPhone.clickToNext("Далее");
        popUpInputEmail.inputEmail("ispolnitel1mt@yandex.ru");
        popUpCreatePassword.checkOpenFrameCreatePassword();
        popUpCreatePassword.inputPassword("111111");
        popUpCreatePassword.clickToComeIn("Войти");
        popUpInputCod.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        popUpInputCod.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForNonMegafon();
    }
}
