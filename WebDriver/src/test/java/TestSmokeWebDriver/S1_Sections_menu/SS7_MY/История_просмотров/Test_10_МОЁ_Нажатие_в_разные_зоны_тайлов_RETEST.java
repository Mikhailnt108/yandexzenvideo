package TestSmokeWebDriver.S1_Sections_menu.SS7_MY.История_просмотров;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_10_МОЁ_Нажатие_в_разные_зоны_тайлов_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value = "10. Нажатие в разные зоны тайлов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void clickingInDifferentAreasTails() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToTabSerials();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();
        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();
        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

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
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.disablePackageTnB();

        // клики в разные области тайлов при отключенном пакете:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToPosterFirstTailBlockCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToTextFirstTailBlockCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
