package TestSmoke.Р1_Авторизация_и_регистрация;

import base.TestBase;
import org.junit.jupiter.api.Test;


public class Test_5_Авторизация_из_карточки_Пакета_Сериалов extends TestBase {

    @Test
    public void loginFromCardPackageSerials() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabPackages();
        packagesPage.checkOpenPackagesPage();
        packagesPage.clickToTabSerialsInMenuPackagesPage();
        packagesPage.clickToTailCardPackageSerials();
        cardPackage.checkOpenCardPackageSerials();
        cardPackage.clickPaymentButtonInCardPackage();
        flowAutorisation();
        pageCMS.deleteAccount();
    }

    private void flowAutorisation() {
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        //headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
