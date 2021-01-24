package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Финблок_юзер_МФ_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void financialBlockingMegafon() {
        headerMenu.goToNilPage();
        flowRegistration();
        headerMenu.openSubsectionPromo();
        promoPage.checkBlockingMegafon();
        promoPage.clickToButtonTopUpPhoneBalance();
        pageCMS.deleteAccount();
    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9250402866");
        popUpInputPhone.clickToNext("Далее");
        popUpCreatePassword.checkOpenFrameCreatePassword();
        popUpCreatePassword.inputPassword("111111");
        popUpCreatePassword.clickToComeIn("Войти");
        popUpInputCod.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdnBlockingMf("79250402866");
        popUpInputCod.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
