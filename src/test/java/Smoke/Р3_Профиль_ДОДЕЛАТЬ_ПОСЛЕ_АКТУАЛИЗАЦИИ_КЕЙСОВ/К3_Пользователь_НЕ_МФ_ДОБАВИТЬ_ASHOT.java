package Smoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Пользователь_НЕ_МФ_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void userNotMegafon() {
        headerMenu.goToNilPage();
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
        headerMenu.openSubsectionPromo();
        promoPage.checkNotMegafon();
        promoPage.clickToButtonGoOver();
    }
}
