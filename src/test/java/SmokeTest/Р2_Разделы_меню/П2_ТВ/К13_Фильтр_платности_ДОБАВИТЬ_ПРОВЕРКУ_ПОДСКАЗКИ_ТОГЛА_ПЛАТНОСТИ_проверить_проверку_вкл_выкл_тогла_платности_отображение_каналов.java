package SmokeTest.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К13_Фильтр_платности_ДОБАВИТЬ_ПРОВЕРКУ_ПОДСКАЗКИ_ТОГЛА_ПЛАТНОСТИ_проверить_проверку_вкл_выкл_тогла_платности_отображение_каналов extends TestBase {
    @Test
    public void checkFilterPayment() {
        headerMenu.goToTvPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabHD();
        tvPage.clickOffToglPayment();
        tvPage.checkTvChannelsOnlyAvailable();
        tvPage.clickOnToglPayment();
        tvPage.checkTvChannelsOnlyPayment();
    }
}
