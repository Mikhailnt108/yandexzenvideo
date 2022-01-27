package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS1_Nil_Basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_NIL_BASIC_Appereance_section_User_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1.2 NIL_Appearance_section_User_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("53962547")
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_Appearance_section_User_SCREENSHOT() throws IOException, InterruptedException, SQLException {
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.checkImageNilPageScrollUser();
        nilPagePW.checkImageCherdakAndBannersUser();
        nilPagePW.checkImageBlocksCollectionWithHeaderUser();
        nilPagePW.checkImageBlockCollectionTvChannelWidePageNilUser();
        // nilPagePW.checkImageBlocksCollectionWithoutHeader();
        nilPagePW.checkImageFooterWidePageUser();
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
