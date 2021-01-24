package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Тариф_не_определился_юзер_МФ_ДОБАВИТЬ_ASHOT extends TestBase {
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
