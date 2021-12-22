package S1_New_and_Best_adMWEB.SS3_Collections.SS1_Nil_collections_basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_COLLECTIONS_Focus_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. NIL_COLLECTIONS_Focus_Guest")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Appearance_User() throws IOException, InterruptedException {
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
    private void flowRegistation() {
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