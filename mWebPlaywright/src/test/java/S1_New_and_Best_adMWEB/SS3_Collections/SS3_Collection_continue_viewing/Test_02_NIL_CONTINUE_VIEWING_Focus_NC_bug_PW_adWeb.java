package S1_New_and_Best_adMWEB.SS3_Collections.SS3_Collection_continue_viewing;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_CONTINUE_VIEWING_Focus_NC_bug_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. NIL_CONTINUE_VIEWING_Focus")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_CONTINUE_VIEWING_Focus() throws IOException, InterruptedException {
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
        nilPagePW.checkTileFilmInBhCollection();
        // просмотр сериала:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.openFirstCardSerialFromPackageKinoPoPodpiskeHeadfull();
        cardSerialPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToNilPageHeadfull();
        nilPagePW.checkTileSerialInBhCollection();
        // просмотр тв передачи:
        headerMenuPW.goToPackagesPageHeadfull();
        packagesPagePW.clickToTailCardPackageKinoPoPodpiskeHeadfull();
        cardTvProgramPW.openCardTvProgramInRecordFromPackageKinoPoPodpiskeHeadfull();
        cardTvProgramPW.moveSliderRewindToVideoPlayerHeadfull();
        headerMenuPW.goToNilPageHeadfull();
        nilPagePW.checkTileTvProgramInBhCollection();
        // добавление нового эпизода:

        // чек тайла новый эпизод:
        nilPagePW.checkTileNewEpisodeInBhCollection();
    }

    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdmWeb("+7 926 019 21 44");
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
