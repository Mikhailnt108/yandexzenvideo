package TestSmokeWebPlaywright.S4_Section_menu.П3_Сериалы_FRESH_от_16_08_21;

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
        flowRegistationMF();
        serialsPagePW.checkImageSerialsPageScrollForUser();
//        serialsPagePW.checkImageCherdakAndBannersForUser();
        serialsPagePW.checkImageBlocksFiltersForUser();
        serialsPagePW.checkImageBlocksCollectionWithHeaderForUser();
        serialsPagePW.checkImageBlocksCollectionWithoutHeaderForUser();
        serialsPagePW.checkImageFooterForUser();
        headerMenuPW.deleteAccountMF("79260172279");
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
