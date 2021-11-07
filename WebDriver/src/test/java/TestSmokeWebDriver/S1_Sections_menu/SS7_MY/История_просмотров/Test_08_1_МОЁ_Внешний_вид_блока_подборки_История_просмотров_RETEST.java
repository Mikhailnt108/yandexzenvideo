package TestSmokeWebDriver.S1_Sections_menu.SS7_MY.История_просмотров;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_1_МОЁ_Внешний_вид_блока_подборки_История_просмотров_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="8.1 Внешний вид блока подборки История просмотров Моё")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void appearanceBlockCollectViewingHistory() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistationMF();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToTabSerials();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

        // чек подборки "продолжить просмотр":
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.scrollToTailWatchAndEdit();
        pageCMS.deleteAccountMF("79260172279");

        // пользователь НЕ МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistationNonMF();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258");
        cardPackage.clickToTabSerials();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();

        // чек подборки "продолжить просмотр":
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.scrollToTailWatchAndEdit();
        pageCMS.deleteAccountNonMF("79261184972");
    }
    private void flowRegistationMF() throws InterruptedException {
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
    private void flowRegistationNonMF() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
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
