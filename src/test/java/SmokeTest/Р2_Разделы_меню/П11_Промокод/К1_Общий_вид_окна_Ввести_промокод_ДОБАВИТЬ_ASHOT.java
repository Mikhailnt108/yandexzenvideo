package SmokeTest.Р2_Разделы_меню.П11_Промокод;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Общий_вид_окна_Ввести_промокод_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void checkViewOfPromoCodePopUp() {
        headerMenu.goToNilPage();
        headerMenu.clickToButtonPromo();
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCod();
    }
}
