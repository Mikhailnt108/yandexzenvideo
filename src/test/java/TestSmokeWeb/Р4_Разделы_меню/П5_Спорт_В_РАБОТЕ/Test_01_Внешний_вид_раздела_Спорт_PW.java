package TestSmokeWeb.Р4_Разделы_меню.П5_Спорт_В_РАБОТЕ;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Test_01_Внешний_вид_раздела_Спорт_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value = "1. Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void visualDesignPageSport() throws IOException, InterruptedException {
        sportPagePW.createSportKindsAndAddChannels();
//        headerMenuPW.goToSportPage();
//        sportPagePW.checkImageCherdakAndBannersSportPageGuest(); // добавить скриншот тесты
//        sportPagePW.checkImageBlockFastFiltersSportPageForGuest(); // добавить скриншот тесты
//        sportPagePW.checkImageBlocksCollectionSportPageFofGuest(); // добавить скриншот тесты
//        sportPagePW.checkImageSportPageScrollForGuest(); // добавить скриншот тесты
//        sportPagePW.checkElementsOnPageSport();
//        sportPagePW.scrollCollectionSportChannelsToRightAndLeft();
//        sportPagePW.scrollCollectionSportVodsToRightAndLeft();
    }
}
