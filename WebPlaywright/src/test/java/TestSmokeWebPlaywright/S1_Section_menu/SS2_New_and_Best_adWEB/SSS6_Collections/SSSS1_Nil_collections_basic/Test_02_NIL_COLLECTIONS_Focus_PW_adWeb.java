package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS6_Collections.SSSS1_Nil_collections_basic;

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
public class Test_02_NIL_COLLECTIONS_Focus_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. NIL_COLLECTIONS_Focus_Guest")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542006")
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Appearance_User() throws IOException, InterruptedException, SQLException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.checkHoverArrowPreviousCollectionPageNilGuest();
        nilPagePW.checkHoverArrowNextCollectionPageNilGuest();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.waitHiddenMessageContentIsBeingLoaded();
        nilPagePW.checkHoverArrowPreviousCollectionPageNilUser();
        nilPagePW.checkHoverArrowNextCollectionPageNilUser();
    }
    private void flowRegistation() throws SQLException {
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
