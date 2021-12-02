package S5_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_SPORT_Appearance_section_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "6. Sport")
    @DisplayName(value = "01_SPORT_Appearance_section")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void SPORT_Appearance_section() throws IOException, InterruptedException {
        sportPagePW.createSportKindsAndAddChannels();
        headerMenuPW.goToSportPage();
        sportPagePW.checkImageCherdakAndBannersSportPageGuest(); // добавить скриншот тесты
        sportPagePW.checkImageBlockFastFiltersSportPageForGuest(); // добавить скриншот тесты
        sportPagePW.checkImageBlocksCollectionSportPageFofGuest(); // добавить скриншот тесты
        sportPagePW.checkImageSportPageScrollForGuest(); // добавить скриншот тесты
        sportPagePW.checkElementsOnPageSport();
        sportPagePW.scrollCollectionSportChannelsToRightAndLeft();
        sportPagePW.scrollCollectionSportVodsToRightAndLeft();
    }
}
