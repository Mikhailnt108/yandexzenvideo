package Smoke.Р2_Разделы_меню.П4_Сериалы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К6_Добавление_в_избранное_сериала extends TestBase {
    @Test
    public void AddingSeriesToFavorites() {
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
        cardSerial.clickButtonFavorites();
        headerMenu.goToMyPageFavorites();
        myPage.checkAddingSerialToFavorites();
    }
}
