package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS6_Collections.SSSS4_Transitions;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;

@ResourceLock(value = "adWebSuitePW#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_06_NIL_COLLECTIONS_Collection_browsing_history_NC_bug_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "6. NIL_COLLECTIONS_Collection_browsing_history")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Collection_browsing_history() throws IOException, InterruptedException, SQLException {
        // User
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
        // клик на тайтл пп подборки:
        nilPagePW.clickOnTitleBhCollectionAndCheckOpenMyHistory();
        headerMenuPW.goToNilPageHeadfull();
        // скролл пп подборки:
        nilPagePW.scrollBhCollectionAndCheckLastTileEditAndShowAll();
        nilPagePW.hoverOnTileEditAndShowAllAndCheckImageTile();
        // клик на ласт тайл пп подборки:
        nilPagePW.clickOnTileEditAndShowAllAndCheckOpenPageMyHistory();
        headerMenuPW.goToNilPageHeadfull();
        // клик на тайл фильм пп подборки:
        nilPagePW.clickTileFilmFromBhCollectAndCheckOpenCardFilm();
        cardFilmPW.checkStartTrailerPlayer();
    }

    private void flowRegistationMF() throws SQLException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.inputCodeMsisdnFromDB("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
