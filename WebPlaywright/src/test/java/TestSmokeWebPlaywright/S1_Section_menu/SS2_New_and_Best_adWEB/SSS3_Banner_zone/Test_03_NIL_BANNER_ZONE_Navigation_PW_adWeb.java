package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS3_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.sql.SQLException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_NIL_BANNER_ZONE_Navigation_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. BANNER_ZONE_Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("53962554")
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Navigation() throws SQLException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.checkScrollBannersToRight();
        nilPagePW.checkScrollBannersToLeft();
        nilPagePW.checkScrollLastBannerToRight();
        nilPagePW.checkScrollFirstBannerToLeft();

        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.checkScrollBannersToRight();
        nilPagePW.checkScrollBannersToLeft();
        nilPagePW.checkScrollLastBannerToRight();
        nilPagePW.checkScrollFirstBannerToLeft();
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
    }
}
