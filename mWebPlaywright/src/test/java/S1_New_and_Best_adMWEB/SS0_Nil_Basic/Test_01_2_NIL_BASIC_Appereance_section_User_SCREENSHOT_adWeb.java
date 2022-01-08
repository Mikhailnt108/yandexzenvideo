package S1_New_and_Best_adMWEB.SS0_Nil_Basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_NIL_BASIC_Appereance_section_User_SCREENSHOT_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1.2 NIL_Appearance_section_User_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_Appearance_section_User_SCREENSHOT() throws IOException, InterruptedException {
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsNilPageAphone();
        headerMenuPW.stopCarouselBanners();
//        nilPagePW.checkImageNilPageScrollUserMWEB();
        nilPagePW.checkImageBannersAphoneUser();
//        nilPagePW.checkImageBlocksCollectionAphoneUser();
//        nilPagePW.checkImageBlocksCollectionTvNilPageAphoneUser();
//        nilPagePW.checkImageBlocksCincAphoneUser();
        nilPagePW.checkImageFooterNilPageAphoneUser();
}
    private void flowRegistation() throws InterruptedException {
        headerMenuPW.tapOnProfileAdMWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 020 50 27");
        headerMenuPW.tapToNextAdMWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.tapToNextAdMWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260205027");
        headerMenuPW.tapToComeInAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");

    }
}
