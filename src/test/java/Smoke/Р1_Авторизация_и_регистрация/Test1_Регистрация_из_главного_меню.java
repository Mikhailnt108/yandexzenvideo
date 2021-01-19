package Smoke.Р1_Авторизация_и_регистрация;

import Smoke.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;



public class Test1_Регистрация_из_главного_меню extends TestBase {
    @Feature(value = "Регистрация из главного меню")
    @Severity(SeverityLevel.BLOCKER)
    @Story(value = "Регистрация из главного меню")

    @Test
    public void registerFromHeaderMenu()  {
        headerMenu.goToNilPage();
        flowRegistation();
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
