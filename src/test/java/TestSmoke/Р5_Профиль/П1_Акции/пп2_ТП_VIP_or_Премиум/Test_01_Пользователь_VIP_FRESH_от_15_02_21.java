package TestSmoke.Р5_Профиль.П1_Акции.пп2_ТП_VIP_or_Премиум;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Пользователь_VIP_FRESH_от_15_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @DisplayName(value ="Пользователь VIP")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "112")
    public void userVip() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistration();
        pageCMS.chooseRoleVip("79260192144");
        headerMenu.openSubsectionPromo();
        promoPage.checkVipUser();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistration() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
