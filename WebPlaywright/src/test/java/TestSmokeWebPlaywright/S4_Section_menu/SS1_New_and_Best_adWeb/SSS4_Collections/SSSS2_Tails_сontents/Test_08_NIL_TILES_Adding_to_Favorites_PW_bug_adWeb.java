package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS2_Tails_сontents;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_08_NIL_TILES_Adding_to_Favorites_PW_bug_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "8. NIL_TILES_Adding_to_Favorites")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_TILES_Adding_to_Favorites() throws IOException, InterruptedException {
        // Guest
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteFilmCollectionGuest();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteSerialCollectionGuest();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteTvProgramCollectionGuest();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteTvChannelCollectionGuest();
        // User
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        // add:
        nilPagePW.clickOnButtonFavoriteAndCheckAddFavoriteFilm();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteAndCheckAddFavoriteSerial();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteAndCheckAddFavoriteTvProgram();
        // remove:
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteFilmFromCollection();
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteSerialFromCollection();
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteTvProgramFromCollection();
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
