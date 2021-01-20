package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Подписка_на_пакет_сериалов extends TestBase {
    @Test
    public void SubscribeToSeriesPackage() throws Exception {
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
        cardSerial.clickToButtonSubscribePackage();
        cardSerial.clickToButtonSubscribeInPopUp();
        cardSerial.checkPopUpSubscribeComplete();
        cardSerial.checkButtonToWatch();
        cardSerial.startVideoPleer();
        headerMenu.goToMyPagePurchases();
        myPage.checkAddingSerialsInPurchases();
        //cardSerial.clickNamePackage();
        //cardPackage.clickPaymentButtonInCardPackage();
    }
}
