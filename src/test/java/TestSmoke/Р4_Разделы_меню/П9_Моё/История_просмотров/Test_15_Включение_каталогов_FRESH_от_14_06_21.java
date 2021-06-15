package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_15_Включение_каталогов_FRESH_от_14_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value = "Включение каталогов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "96")
    public void enablingCatalogViewSerialsPage() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();
        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();
        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        //чек отсутствия подборки 'Продолжить просмотр' в режиме 'каталог':
        headerMenu.goToSerialsPage();
        serialsPage.clickOnFastFilterGenre();
        serialsPage.checkAbsentBlockCollectHistoryWatch();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
