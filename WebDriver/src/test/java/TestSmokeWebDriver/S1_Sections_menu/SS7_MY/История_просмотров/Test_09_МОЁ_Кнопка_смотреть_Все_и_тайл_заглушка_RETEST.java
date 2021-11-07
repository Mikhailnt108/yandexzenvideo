package TestSmokeWebDriver.S1_Sections_menu.SS7_MY.История_просмотров;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_МОЁ_Кнопка_смотреть_Все_и_тайл_заглушка_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="9. Кнопка смотреть Все и тайл заглушка")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void buttonAllWatchAndTailWatchAndEdit() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistationMF();
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
        // переходы в историю просмотра:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        headerMenu.goToSerialsPage();
        serialsPage.scrollToTailWatchAndEdit();
        serialsPage.clickToTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
        pageCMS.deleteAccountMF("79260172279");

        // пользователь НЕ МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistationNonMF();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258");
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
        // переходы в историю просмотра:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        headerMenu.goToSerialsPage();
        serialsPage.scrollToTailWatchAndEdit();
        serialsPage.clickToTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
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
