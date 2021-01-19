package Smoke.Р2_Разделы_меню.П4_Сериалы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К4_Пауза_серии extends TestBase {
    @Test
    public void pauseSeries() throws Exception {
        headerMenu.goToSerialsPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.clickToPauseVideoPleer();
        cardSerial.clickToPlayVideoPleer();
        cardSerial.clickToSpaceToVideoPleer();
        cardSerial.clickToLeftButtonMouseToVideoPleer();

    }
}
