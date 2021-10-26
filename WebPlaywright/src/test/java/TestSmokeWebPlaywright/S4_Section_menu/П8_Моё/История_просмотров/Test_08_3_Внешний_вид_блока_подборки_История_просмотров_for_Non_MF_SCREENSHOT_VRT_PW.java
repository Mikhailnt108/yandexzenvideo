package TestSmokeWebPlaywright.S4_Section_menu.П8_Моё.История_просмотров;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_3_Внешний_вид_блока_подборки_История_просмотров_for_Non_MF_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Внешний вид блока подборки История просмотров для НЕ МФ (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2")
    public void appearanceBlockCollectViewingHistory() throws Exception {
        // пользователь НЕ МФ:
        // подключение пакета:
        headerMenuPW.goToNilPage();
        flowRegistationNonMF();
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258");
        headerMenuPW.saveCookiesBrowserHeadless();
        headerMenuPW.getCookiesAndOpenHeadfullBrowser();

        // просмотр первого сериала:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.openFirstCardSerialFromPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToSerialsPageHeadfull();

        // просмотр второго сериала:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.openSecondCardSerialFromPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToSerialsPageHeadfull();

        // просмотр третьего сериала:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.openThirdCardSerialFromPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToSerialsPageHeadfull();

        // скриншот подборки "продолжить просмотр":
        headerMenuPW.reloadPageHeadfull();
        serialsPagePW.checkImageBlockCollectHistoryWatchForNonMFfHeadfull();
    }
    private void flowRegistationNonMF() throws InterruptedException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 118 49 72");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputEmail("+7 926 118 49 72");
        headerMenuPW.checkInputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenuPW.clickToNext();
        authPagePW.inputValidPasswordRegister("111111");
        authPagePW.inputValidPasswordRegister("111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
