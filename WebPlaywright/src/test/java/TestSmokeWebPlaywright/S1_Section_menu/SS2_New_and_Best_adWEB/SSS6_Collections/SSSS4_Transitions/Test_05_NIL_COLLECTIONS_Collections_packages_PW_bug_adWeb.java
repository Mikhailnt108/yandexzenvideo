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
public class Test_05_NIL_COLLECTIONS_Collections_packages_PW_bug_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "5. NIL_COLLECTIONS_Collections_packages")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("53962586")
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Collections_packages() throws IOException, InterruptedException, SQLException {
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
