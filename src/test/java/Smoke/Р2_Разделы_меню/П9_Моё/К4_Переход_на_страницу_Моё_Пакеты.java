package Smoke.Р2_Разделы_меню.П9_Моё;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К4_Переход_на_страницу_Моё_Пакеты extends TestBase {
    @Test
    public void goToPackagesPage() {
        headerMenu.goToPackagesPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.paymentPackageTnB();
        headerMenu.goToMyPageSubscriptions();
        myPage.checkSubscriptionsPackages();
    }
}
