package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_13_Фильтр_платности_ДОБАВИТЬ_ПРОВЕРКУ_ПОДСКАЗКИ_ТОГЛА_ПЛАТНОСТИ_проверить_проверку_вкл_выкл_тогла_платности_отображение_каналов extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "13. Фильтр платности")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkFilterPayment() {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabHD();
        tvPage.clickOffToglPayment();
        tvPage.checkTvChannelsOnlyAvailable();
        tvPage.clickOnToglPayment();
        tvPage.checkTvChannelsOnlyPayment();
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
