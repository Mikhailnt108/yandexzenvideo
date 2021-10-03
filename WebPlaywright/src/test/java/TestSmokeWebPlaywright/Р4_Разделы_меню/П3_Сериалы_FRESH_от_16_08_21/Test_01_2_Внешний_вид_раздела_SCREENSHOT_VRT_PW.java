package TestSmokeWebPlaywright.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_Внешний_вид_раздела_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Внешний вид раздела (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#4")
    public void appearanceSectionSerialsPage() throws Exception {
        serialsPagePW.checkImageSerialsPageScrollForGuest();
//        serialsPagePW.checkImageCherdakAndBannersForGuest();
        serialsPagePW.checkImageBlocksFiltersForGuest();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForGuest();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForGuest();
        serialsPagePW.checkImageFooterForGuest();
        // пользоваеть авторизован:
        headerMenuPW.goToSerialsPage();
        flowRegistation();
        serialsPagePW.checkImageSerialsPageScrollForUser();
//        serialsPagePW.checkImageCherdakAndBannersForUser();
        serialsPagePW.checkImageBlocksFiltersForUser();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForUser();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForUser();
        serialsPagePW.checkImageFooterForUser();
        headerMenuPW.deleteAccountMF("79260172279");
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 925 011 01 66");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 925 011 01 66", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79250110166");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
