package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS4_Transitions;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_NIL_COLLECTIONS_Editorial_collections_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
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
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
