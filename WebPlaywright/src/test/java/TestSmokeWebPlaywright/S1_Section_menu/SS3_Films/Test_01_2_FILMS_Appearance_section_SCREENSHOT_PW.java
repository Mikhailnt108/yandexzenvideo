package TestSmokeWebPlaywright.S1_Section_menu.SS3_Films;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_FILMS_Appearance_section_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="FILMS_Appearance_section_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("36965362")
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void FILMS_Appearance_section_SCREENSHOT() throws Exception {
        // пользователь НЕ авторизован:
        filmsPagePW.checkImageFilmsPageScrollForGuest();
        filmsPagePW.checkImageCherdakAndBannersForUnauthorized();
        filmsPagePW.checkImageBlocksFiltersForUnauthorized();
        filmsPagePW.checkImageBlocksCollectionWithHeaderForUnauthorized();
        filmsPagePW.checkImageBlocksCollectionWithoutHeaderForUnauthorized();
        filmsPagePW.checkImageFooterForUnauthorized();

        // пользоваеть авторизован:
        headerMenuPW.goToFilmsPage();
        flowRegistationMF();
        headerMenuPW.goToFilmsPage();
        filmsPagePW.checkImageFilmsPageScrollForUser();
        filmsPagePW.checkImageCherdakAndBannersForUser();
        filmsPagePW.checkImageBlocksFiltersForUser();
        filmsPagePW.checkImageBlocksCollectionWithHeaderForUser();
        filmsPagePW.checkImageBlocksCollectionWithoutHeaderForUser();
        filmsPagePW.checkImageFooterForUser();
        headerMenuPW.deleteAccountMF("79260205027");
    }

    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginNonAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
