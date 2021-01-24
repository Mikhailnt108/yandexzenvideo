package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_2_Подписка_на_пакет_сериалов extends TestBase {
    @Test
    public void SubscribeToSeriesPackage() throws Exception {
        headerMenu.goToSerialsPage();
        flowRegistation();
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.clickToButtonSubscribePackage();
        cardSerial.clickToButtonSubscribeInPopUp();
        cardSerial.checkPopUpSubscribeComplete();
        cardSerial.checkButtonToWatch();
        cardSerial.startVideoPleer();
        headerMenu.goToMyPagePurchases();
        myPage.checkAddingSerialsInPurchases();
        pageCMS.deleteAccount();
        //cardSerial.clickNamePackage();
        //cardPackage.clickPaymentButtonInCardPackage();
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
