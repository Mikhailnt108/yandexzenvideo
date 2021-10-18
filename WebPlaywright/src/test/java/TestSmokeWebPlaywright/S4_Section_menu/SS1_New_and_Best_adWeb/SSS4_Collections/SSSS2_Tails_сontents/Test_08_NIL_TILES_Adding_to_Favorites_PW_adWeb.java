package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS2_Tails_сontents;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_08_NIL_TILES_Adding_to_Favorites_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "8. NIL_TILES_Adding_to_Favorites")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_TILES_Adding_to_Favorites() throws IOException, InterruptedException {
        // Guest
//        headerMenuPW.goToNilPage();
//        nilPagePW.clickOnButtonFavoriteFilmCollectionGuest();
//        headerMenuPW.goToNilPage();
//        nilPagePW.clickOnButtonFavoriteSerialCollectionGuest();
//        headerMenuPW.goToNilPage();
//        nilPagePW.clickOnButtonFavoriteTvProgramCollectionGuest();
//        headerMenuPW.goToNilPage();
//        nilPagePW.clickOnButtonFavoriteTvChannelCollectionGuest();
        // User
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.clickOnButtonFavoriteAndCheckAddFavoriteFilm();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteAndCheckAddFavoriteSerial();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonFavoriteAndCheckAddFavoriteTvProgram();
    }
    private void flowRegistation() {
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
