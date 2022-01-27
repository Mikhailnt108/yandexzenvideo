package TestSmokeWebDriver.S1_Sections_menu.SS2_Films;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_FILMS_Appearance_section_User extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="Appearance_section_User")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("36965362")
    @Test
    @Tag("SuiteWD#2")
    public void appearanceSectionFilmsPage() throws Exception {
        // пользоваеть авторизован:
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.checkElementsFilmsPage();
        headerMenu.goToFilmsPage();
        filmsPage.checkElementsFilmsPage();
        filmsPage.checkElementsBannersCarousel();
        filmsPage.autoScrollBanners();
        filmsPage.scrollBannersToLeft();
        filmsPage.scrollBannersToRight();
        filmsPage.scrollСollectionToRightAndLeft();
        pageCMS.deleteAccountMF("79260205027");
    }

    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
