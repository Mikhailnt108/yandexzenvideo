package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_10_Нажатие_в_разные_зоны_тайлов_FRESH_от_14_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value = "Нажатие в разные зоны тайлов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "91")
    public void clickingInDifferentAreasTails() throws Exception {
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

        // клики в разные области тайлов при подключенном пакете:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToPosterFirstTailBlockCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToTextFirstTailBlockCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();

        // отключить пакет просмотренных сериалов:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.disablePackageTnB();

        // клики в разные области тайлов при отключенном пакете:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToPosterFirstTailBlockCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToTextFirstTailBlockCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
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
