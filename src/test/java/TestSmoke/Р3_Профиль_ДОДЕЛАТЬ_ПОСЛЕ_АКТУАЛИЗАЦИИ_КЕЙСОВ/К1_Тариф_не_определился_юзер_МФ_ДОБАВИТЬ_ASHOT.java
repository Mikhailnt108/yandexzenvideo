package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К1_Тариф_не_определился_юзер_МФ_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Тариф не определился юзер МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void tariffNotDefined() {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseNotDefinedTariff();
        headerMenu.openSubsectionPromo();
        promoPage.checkNotDefinedTariff();
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
