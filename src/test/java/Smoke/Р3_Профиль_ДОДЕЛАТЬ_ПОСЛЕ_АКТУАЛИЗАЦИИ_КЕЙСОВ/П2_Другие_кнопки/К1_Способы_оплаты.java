package Smoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ.П2_Другие_кнопки;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Способы_оплаты extends TestBase {
    @Test
    public void paymentMethod() {
        headerMenu.goToNilPage();
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
        headerMenu.openSubsectionPaymentMethod();
    }
}
