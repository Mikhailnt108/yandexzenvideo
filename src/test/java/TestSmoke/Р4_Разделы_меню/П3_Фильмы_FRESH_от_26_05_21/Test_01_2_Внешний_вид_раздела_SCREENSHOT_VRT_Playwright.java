package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBasePlaywright;
import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import io.qameta.allure.*;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_2_Внешний_вид_раздела_SCREENSHOT_VRT_Playwright extends TestBasePlaywright {
    @Rule
    public VideoRule videoRule = new VideoRule();
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Внешний_вид_раздела (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Video
    @RepeatedTest(1)
    public void appearanceSectionFilmsPage() throws Exception {
        // пользователь НЕ авторизован:
        filmsPagePW.checkImageFilmsPageScrollForGuest();
        filmsPagePW.checkImageCherdakAndBannersForUnauthorized();
        filmsPagePW.checkImageBlocksFiltersForUnauthorized();
        filmsPagePW.checkImageBlocksCollectionWithHeaderForUnauthorized();
        filmsPagePW.checkImageBlocksCollectionWithoutHeaderForUnauthorized();
        filmsPagePW.checkImageFooterForUnauthorized();

        // пользоваеть авторизован:
        headerMenuPW.goToFilmsPage();
        flowRegistation();
        filmsPagePW.checkImageFilmsPageScrollForUser();
        filmsPagePW.checkImageCherdakAndBannersForUser();
        filmsPagePW.checkImageBlocksFiltersForUser();
        filmsPagePW.checkImageBlocksCollectionWithHeaderForUser();
        filmsPagePW.checkImageBlocksCollectionWithoutHeaderForUser();
        filmsPagePW.checkImageFooterForUser();
        headerMenuPW.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
