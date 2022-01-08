package S1_New_and_Best_adMWEB.SS3_Collections.SS4_Transitions;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_NIL_COLLECTIONS_Editorial_collections_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1. NIL_COLLECTIONS_Editorial_collections")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Editorial_collections() throws IOException, InterruptedException {
        // Guest
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnTitleEditCollectionAndCheckOpenCollectionPage();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileFilmCollectionAndCheckOpenCardFilm();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileSerialCollectionAndCheckOpenCardSerial();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileTvProgramCollectionAndCheckOpenCardTvProgram();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileTvChannelCollectionAndCheckOpenCardTvChannel();
        headerMenuPW.goToNilPage();
        // User
        flowRegistationMF();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnTitleEditCollectionAndCheckOpenCollectionPage();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileFilmCollectionAndCheckOpenCardFilm();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileSerialCollectionAndCheckOpenCardSerial();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileTvProgramCollectionAndCheckOpenCardTvProgram();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTileTvChannelCollectionAndCheckOpenCardTvChannel();
    }

    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 019 21 44");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260192144");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
