package TestSmoke.Р3_Разделы_меню.П11_Промокод;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Общий_вид_окна_Ввести_промокод_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "11. Промокод")
    @DisplayName(value ="Общий вид окна Ввести_промокод")
    @Severity(SeverityLevel.BLOCKER)
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
        headerMenu.checkLoginUserIsCorrectFlow();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCode();
    }
}
