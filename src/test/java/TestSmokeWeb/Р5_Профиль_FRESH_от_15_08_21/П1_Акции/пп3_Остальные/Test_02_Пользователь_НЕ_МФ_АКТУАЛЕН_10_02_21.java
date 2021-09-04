package TestSmokeWeb.Р5_Профиль_FRESH_от_15_08_21.П1_Акции.пп3_Остальные;

import base.TestBaseWebDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_Пользователь_НЕ_МФ_АКТУАЛЕН_10_02_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @DisplayName(value ="Пользователь НЕ_МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3Exp")
    public void userNotMegafon() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistationNonMF();
        headerMenu.openSubsectionPromo();
        promoPage.checkNotMegafon();
        promoPage.clickToButtonGoOver();
        pageCMS.deleteAccountNonMF("79261184972");
    }

    private void flowRegistationNonMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputEmail("9261184972");
        headerMenu.checkElementsPopUpInputEmail();
        headerMenu.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenu.clickToNext("Далее");
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
