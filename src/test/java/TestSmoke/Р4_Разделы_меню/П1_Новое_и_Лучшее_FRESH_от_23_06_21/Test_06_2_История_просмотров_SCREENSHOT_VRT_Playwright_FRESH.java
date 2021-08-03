package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_06_2_История_просмотров_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "История просмотров (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void historyViewing() throws Exception {
        headerMenuPW.goToPackagesPage();
        flowRegistationMF();
        packagesPagePW.checkOpenShopPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.checkOpenCardPackage();
        cardPackagePW.paymentPackageTnB();

        //просмотр фильма:
        cardPackagePW.clickOnTailFirstCardFilm();
        cardFilmPW.moveSliderRewindToVideoPleer();
        headerMenuPW.goToNilPage();

        //просмотр сериала:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToFirstTailCardPackage();
        cardPackagePW.clickToFirstTailCardSerial();
        cardSerialPW.moveSliderRewindToVideoPleer();
        headerMenuPW.goToNilPage();

        //просмотр тв передачи:
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToFirstTailCardPackage();
        cardPackagePW.clickOnTailCardChannel();
        cardTvChannelPW.clickTvProgramRecordInCardTvChannel();
        cardTvProgramPW.moveSliderRewindToVideoPlayer();
        headerMenuPW.goToNilPage();
        headerMenuPW.checkImageBlockCollectHistoryWatch();
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
