package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS4_Collections.SSSS4_Transitions;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_05_NIL_COLLECTIONS_Collections_packages_PW_bug_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "5. NIL_COLLECTIONS_Collections_packages")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Collections_packages() throws IOException, InterruptedException {
        // Guest
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnTitlePackagesCollectionAndCheckOpenCollectionPage();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTilePackageCollectionAndCheckOpenCardPackage();
        headerMenuPW.goToNilPage();
        // User
        flowRegistationMF();
        nilPagePW.clickOnTitlePackagesCollectionAndCheckOpenCollectionPage();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToTilePackageCollectionAndCheckOpenCardPackage();
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