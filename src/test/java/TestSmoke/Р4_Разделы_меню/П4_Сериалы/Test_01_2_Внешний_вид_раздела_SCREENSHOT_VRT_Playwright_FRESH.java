package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_2_Внешний_вид_раздела_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Внешний вид раздела (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionSerialsPage() throws Exception {
        serialsPagePW.checkImageCherdakAndBannersForUnauthorized();
        serialsPagePW.checkImageBlocksFiltersForUnauthorized();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForUnauthorized();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForUnauthorized();
        serialsPagePW.checkImageFooterForUnauthorized();
        serialsPagePW.checkImageSerialsPageScrollForUnauthorized();
        // пользоваеть авторизован:
        headerMenuPW.goToSerialsPage();
        flowRegistation();
        serialsPagePW.checkImageCherdakAndBannersForAuthorized();
        serialsPagePW.checkImageBlocksFiltersForAuthorized();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForAuthorized();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForAuthorized();
        serialsPagePW.checkImageFooterForAuthorized();
        serialsPagePW.checkImageSerialsPageScrollForAuthorized();
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
