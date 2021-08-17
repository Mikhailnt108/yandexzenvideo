package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_08_1_Внешний_вид_блока_подборки_История_просмотров_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Внешний вид блока подборки История просмотров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceBlockCollectViewingHistory() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistationMF();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // чек подборки "продолжить просмотр":
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.scrollToTailWatchAndEdit();
        pageCMS.deleteAccountMF("79260192144");

        // пользователь НЕ МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistationNonMF();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258");
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // чек подборки "продолжить просмотр":
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.scrollToTailWatchAndEdit();
        pageCMS.deleteAccountNonMF("79261184972");
    }
    private void flowRegistationMF() {
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
