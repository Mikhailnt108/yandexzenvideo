package TestSmoke.Р4_Разделы_меню.П5_Спорт_В_РАБОТЕ;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SPORT_01_Вгешний_вид_раздела_Спорт_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value ="1. Внешний вид раздела (скринщоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectioтSportPage() throws Exception {
        headerMenuPW.goToSportPage();
//        sportPagePW.checkElementsOnPageSport();
//        headerMenu.goToFilmsPage();
//        filmsPage.checkElementsFilmsPage();
//        filmsPage.checkElementsBannersCarousel();
//        filmsPage.autoScrollBanners();
//        filmsPage.scrollBannersToLeft();
//        filmsPage.scrollBannersToRight();
//        filmsPage.scrollСollectionToRightAndLeft();

        kidsPagePW.checkImageKidsPageScrollForGuest();
        kidsPagePW.checkImageCherdakAndBannersForGuest();
        kidsPagePW.checkImageBlocksCollectionWithHeaderFofGuest();
        kidsPagePW.checkImageBlocksCollectionWithoutHeaderForGuest();
        kidsPagePW.checkImageFooterForGuest();
//        kidsPagePW.checkBackgroundKidsPage();
    }
}
