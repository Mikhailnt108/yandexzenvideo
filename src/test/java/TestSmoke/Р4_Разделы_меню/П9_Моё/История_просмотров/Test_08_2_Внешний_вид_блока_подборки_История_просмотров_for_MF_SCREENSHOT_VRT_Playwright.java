package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_08_2_Внешний_вид_блока_подборки_История_просмотров_for_MF_SCREENSHOT_VRT_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Внешний вид блока подборки История просмотров для МФ (скриншоты)")
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
        serialsPagePW.checkImageBlockCollectHistoryWatchForMfHeadfull();


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
}
