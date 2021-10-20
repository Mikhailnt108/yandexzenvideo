package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS3_Collection_browsing_history;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_NIL_BROWSING_HISTORY_Appearance_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1. NIL_BROWSING_HISTORY_Appearance")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void historyViewing() throws Exception {
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        headerMenuPW.goToPackagesPage();
        packagesPagePW.checkOpenShopPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.checkOpenCardPackage();
        cardPackagePW.paymentPackageTnB();
        headerMenuPW.saveCookiesBrowserHeadless();
        headerMenuPW.getCookiesAndOpenHeadfullBrowser();
        // просмотр фильма:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardFilmPW.openFirstCardFilmFromPackageKinoPoPodpiskeHeadfull();
        cardFilmPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToNilPageHeadfull();
        // просмотр сериала:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.openFirstCardSerialFromPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToNilPageHeadfull();
        // просмотр тв передачи:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardTvProgramPW.openCardTvProgramInRecordFromPackageKinoPoPodpiskeHeadfull();
        cardTvProgramPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToNilPageHeadfull();
        // скриншот-тест подборки:
        nilPagePW.checkImageBlockCollectHistoryWatchOnNilPage();
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
