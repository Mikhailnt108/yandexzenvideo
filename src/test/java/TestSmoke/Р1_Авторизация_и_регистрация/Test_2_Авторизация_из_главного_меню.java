package TestSmoke.Р1_Авторизация_и_регистрация;

import base.TestBase;
import org.junit.jupiter.api.Test;


public class Test_2_Авторизация_из_главного_меню extends TestBase {

    @Test
    public void loginFromHeaderMenu()  {
        headerMenu.goToNilPage();
        flowRegister();
        headerMenu.logOut();
        flowAuthorization();
        pageCMS.deleteAccount();
    }

    private void flowAuthorization() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }

    private void flowRegister() {
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