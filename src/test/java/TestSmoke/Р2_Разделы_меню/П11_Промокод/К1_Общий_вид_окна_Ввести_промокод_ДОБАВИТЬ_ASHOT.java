package TestSmoke.Р2_Разделы_меню.П11_Промокод;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К1_Общий_вид_окна_Ввести_промокод_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Общий вид окна Ввести промокод")
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
        headerMenu.checkLoginUserIsCorrect();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCod();
    }
}
