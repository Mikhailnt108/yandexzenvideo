package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBaseWebDriver;
import com.automation.remarks.junit.VideoRule;
import io.qameta.allure.*;
import com.automation.remarks.video.annotations.Video;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_Внешний_вид_раздела_ASHOT_FRESH_от_01_07_21WebDriver extends TestBaseWebDriver {
    @Rule
    public VideoRule videoRule = new VideoRule();
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Внешний_вид_раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Video
    @RepeatedTest(3)
    public void appearanceSectionFilmsPage() throws Exception {
//        // пользователь НЕ авторизован
//        headerMenu.goToFilmsPage();
//        filmsPage.checkImageDifferCherdakAndBannersGuest();
//        filmsPage.checkImageDifferBreadcrumbsAndBlocksFiltersGuest(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        headerMenu.goToFilmsPage();
//        filmsPage.checkImageDifferBlocksCollectionGuest(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        filmsPage.checkImageDifferFooter();
//        headerMenu.goToFilmsPage();
        filmsPage.checkImageDifferFilmsPageScrollGuest(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        filmsPage.checkElementsFilmsPage();
//        filmsPage.checkElementsBannersCarousel();
//        filmsPage.autoScrollBanners();
//        filmsPage.scrollBannersToLeft();
//        filmsPage.scrollBannersToRight();
//        filmsPage.scrollСollectionToRightAndLeft();
        // пользоваеть авторизован:
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.checkElementsFilmsPage();
        filmsPage.checkImageDifferCherdakAndBannersUser();
        filmsPage.checkImageDifferBreadcrumbsAndBlocksFiltersUser(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
        filmsPage.checkImageDifferBlocksCollectionUser(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
        filmsPage.checkImageDifferFooter();
        headerMenu.goToFilmsPage();
        filmsPage.checkImageDifferFilmsPageScrollUser(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
        filmsPage.checkElementsFilmsPage();
        filmsPage.checkElementsBannersCarousel();
        filmsPage.autoScrollBanners();
        filmsPage.scrollBannersToLeft();
        filmsPage.scrollBannersToRight();
        filmsPage.scrollСollectionToRightAndLeft();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
