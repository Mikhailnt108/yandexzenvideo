package TestSmoke.Р4_Разделы_меню.П6_Спорт;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Переходы_в_карточки_контента_ДОБАВИТЬ_ASHOT_АКТУАЛЕН_19_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value ="Переходы в карточки контента")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToContentCards() throws InterruptedException {
        headerMenu.goToSportPage();
        sportPage.autoScrollBanners();
        sportPage.scrollBannersToLeft();
        sportPage.scrollBannersToRight();
        sportPage.chooseDotCarouselBanners();
        sportPage.clickToBanner();
        headerMenu.goToSportPage();
        sportPage.checkLogoTvOnTailTvChannel();
        sportPage.clickToTailTvChannel();
        headerMenu.goToSportPage();
        sportPage.checkElementsOnTailTvProgram();
        sportPage.clickToTailTvProgram();
    }
}