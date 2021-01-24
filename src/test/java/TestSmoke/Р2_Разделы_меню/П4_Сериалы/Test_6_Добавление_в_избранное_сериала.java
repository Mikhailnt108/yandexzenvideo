package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_6_Добавление_в_избранное_сериала extends TestBase {
    @Test
    public void AddingSeriesToFavorites() {
        headerMenu.goToSerialsPage();
        flowRegistation();
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.clickButtonFavorites();
        headerMenu.goToMyPageFavorites();
        myPage.checkAddingSerialToFavorites();
        pageCMS.deleteAccount();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
