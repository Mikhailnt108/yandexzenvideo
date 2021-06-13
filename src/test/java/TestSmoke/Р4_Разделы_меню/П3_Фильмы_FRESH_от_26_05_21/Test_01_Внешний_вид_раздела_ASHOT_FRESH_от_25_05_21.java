package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_Внешний_вид_раздела_ASHOT_FRESH_от_25_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Внешний_вид_раздела")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionFilmsPage() throws Exception {
        // пользователь НЕ авторизован
        headerMenu.goToFilmsPage();
//        filmsPage.checkImageDifferCherdakAndBanners();
//        filmsPage.checkImageDifferBreadcrumbsAndBlocksFilters(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        filmsPage.checkImageDifferBlocksCollection(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        filmsPage.checkImageDifferFooter();
//        filmsPage.checkImageDifferFilmsPageScroll(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
        filmsPage.checkElementsFilmsPage();
        filmsPage.checkElementsBannersCarousel();
        filmsPage.autoScrollBanners();
        filmsPage.scrollBannersToLeft();
        filmsPage.scrollBannersToRight();
        filmsPage.scrollСollectionToRightAndLeft();
        // пользоваеть авторизован:
        flowRegistation();
        filmsPage.checkElementsFilmsPage();
//        filmsPage.checkImageDifferCherdakAndBanners();
//        filmsPage.checkImageDifferBreadcrumbsAndBlocksFilters(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        filmsPage.checkImageDifferBlocksCollection(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
//        filmsPage.checkImageDifferFooter();
//        filmsPage.checkImageDifferFilmsPageScroll(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
