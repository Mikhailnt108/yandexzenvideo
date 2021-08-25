package TestSmoke.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#1")
public class Test_01_1_СЕРИАЛЫ_Внешний_вид_раздела_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="1.1 Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionSerialsPage() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsSerialsPage();
        serialsPage.checkElementsBannersCarousel();
        serialsPage.autoScrollBanners();
        serialsPage.scrollBannersToLeft();
        serialsPage.scrollBannersToRight();
        serialsPage.scrollСollectionToRightAndLeft();
        flowRegistation();
        serialsPage.checkElementsSerialsPage();
        serialsPage.checkElementsBannersCarousel();
        serialsPage.autoScrollBanners();
        serialsPage.scrollBannersToLeft();
        serialsPage.scrollBannersToRight();
        serialsPage.scrollСollectionToRightAndLeft();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() {
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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
