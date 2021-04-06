package TestSmoke.Р3_Профиль.П1_Акции.пп2_ТП_VIP_or_Премиум;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Пользователь_VIP_ДОБАВИТЬ_ASHOT_АКТУАЛЕН_15_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @DisplayName(value ="Пользователь VIP")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void userVip() throws InterruptedException {
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
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
