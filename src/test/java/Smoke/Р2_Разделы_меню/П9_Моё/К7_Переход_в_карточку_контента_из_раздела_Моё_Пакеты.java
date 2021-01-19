package Smoke.Р2_Разделы_меню.П9_Моё;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К7_Переход_в_карточку_контента_из_раздела_Моё_Пакеты extends TestBase {
    @Test
    public void goToCardPackageFromMyPagePackages() {
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
        myPage.clickToTailCardPackageFromSubscriptions();
        cardPackage.checkOpenCardPackage();
    }
}
