package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_08_2_Внешний_вид_блока_подборки_История_просмотров_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Внешний вид блока подборки История просмотров (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceBlockCollectViewingHistory() throws Exception {
        // пользователь МФ:
        // подключение пакета:
        headerMenuPW.goToPackagesPage();
        flowRegistationMF();
        packagesPagePW.checkOpenShopPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.checkOpenCardPackage();
        cardPackagePW.paymentPackageTnB();

        // просмотр первого сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.clickToFirstTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();
        headerMenuPW.goToSerialsPage();

        // просмотр второго сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.clickToSecondTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();
        headerMenuPW.goToSerialsPage();

        // просмотр третьего сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.clickToThirdTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();
        headerMenuPW.goToSerialsPage();

        // скриншот подборки "продолжить просмотр":
        headerMenuPW.goToSerialsPage();
        headerMenuPW.reloadPage();
        serialsPagePW.checkImageBlockCollectHistoryWatchForMF();
        headerMenuPW.deleteAccountMF("79260192144");

        // пользователь НЕ МФ:
        // подключение пакета:
        headerMenuPW.goToNilPage();
        flowRegistationNonMF();
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258");

        // просмотр первого сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.clickToFirstTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();

        // просмотр второго сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.clickToSecondTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();

        // просмотр третьего сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.clickToThirdTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();

        // скриншот подборки "продолжить просмотр":
        headerMenuPW.goToSerialsPage();
        headerMenuPW.reloadPage();
        serialsPagePW.checkImageBlockCollectHistoryWatchForNonMF();
        headerMenuPW.deleteAccountNonMF("79261184972");
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
    private void flowRegistationNonMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 118 49 72");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputEmail("+7 926 118 49 72");
        headerMenuPW.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenuPW.clickToNext();
        headerMenuPW.inputPassword("111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
