package TestsPlayer.SS9_MY_Continue_viewing;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.sql.SQLException;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_3_MY_Appearance_block_collection_continue_viewing_for_NON_MF_SCREENSHOT_PLAYER_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "9. MY")
    @DisplayName(value ="08_3_MY_Appearance_block_collection_continue_viewing_for_NON_MF_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2")
    public void MY_Appearance_block_collection_continue_viewing_for_NON_MF_SCREENSHOT() throws Exception {
        // пользователь НЕ МФ:
        // подключение пакета:
        headerMenuPW.goToNilPage();
        flowRegistationNonMF();
        headerMenuPW.goToPackagesPage();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiske();
        cardPackagePW.paymentPackageTnBForNonMFBankCardNotLinked();
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
    private void flowRegistationNonMF() throws InterruptedException, SQLException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdWeb("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
