package S3_Serials;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_SERIALS_Appearance_section_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value ="01_2_SERIALS_Appearance_section_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void SERIALS_Appearance_section_SCREENSHOT() throws Exception {
        serialsPagePW.checkImageSerialsPageScrollForGuest();
        serialsPagePW.checkImageCherdakAndBannersForGuest();
        serialsPagePW.checkImageBlocksFiltersForGuest();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForGuest();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForGuest();
        serialsPagePW.checkImageFooterForGuest();
        // пользоваеть авторизован:
        headerMenuPW.goToSerialsPage();
        flowRegistationMF();
        headerMenuPW.goToSerialsPage();
        serialsPagePW.checkImageSerialsPageScrollForUser();
        serialsPagePW.checkImageCherdakAndBannersForUser();
        serialsPagePW.checkImageBlocksFiltersForUser();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForUser();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForUser();
        serialsPagePW.checkImageFooterForUser();
        headerMenuPW.deleteAccountMF("79260205027");
    }
    private void flowRegistationMF() throws InterruptedException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginNonAdmWeb("+7 926 020 50 27");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
