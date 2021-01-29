package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К3_Пользователь_НЕ_МФ_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Пользователь НЕ МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userNotMegafon() {
        headerMenu.goToNilPage();
        flowRegistration();
        headerMenu.openSubsectionPromo();
        promoPage.checkNotMegafon();
        promoPage.clickToButtonGoOver();
        pageCMS.deleteAccount();
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
        pageCMS.copyPasteCodMsisdnForNotMF("79261184972");
        popUpInputCod.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForNotMegafon();
    }
}
