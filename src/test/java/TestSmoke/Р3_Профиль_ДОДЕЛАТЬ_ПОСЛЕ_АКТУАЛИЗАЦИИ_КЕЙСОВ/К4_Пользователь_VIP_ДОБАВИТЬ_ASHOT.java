package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К4_Пользователь_VIP_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Пользователь VIP")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userVip() {
        headerMenu.goToNilPage();
        flowRegistration();
        pageCMS.chooseRoleVip();
        headerMenu.openSubsectionPromo();
        promoPage.checkVipUser();
        pageCMS.deleteAccount();
    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpCreatePassword.checkOpenFrameCreatePassword();
        popUpCreatePassword.inputPassword("111111");
        popUpCreatePassword.clickToComeIn("Войти");
        popUpInputCod.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        popUpInputCod.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
