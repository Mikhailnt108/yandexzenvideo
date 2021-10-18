package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS2_Tails_сontents;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_03_NIL_TILES_Tv_program_in_Air_or_Today_from_collection_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "3.1 NIL_TILES_Tv_program_in_Air_from_collection")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_TILES_Tv_program_in_Air_from_collection() throws IOException, InterruptedException {
        // Guest
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsTileTvProgramInAirFromCollection();
        nilPagePW.checkImageHoverOnTileTvProgramInAirFromCollectionGust();
        // User
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.checkElementsTileTvProgramInAirFromCollection();
        nilPagePW.checkImageHoverOnTileTvProgramInAirFromCollectionUser();
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
