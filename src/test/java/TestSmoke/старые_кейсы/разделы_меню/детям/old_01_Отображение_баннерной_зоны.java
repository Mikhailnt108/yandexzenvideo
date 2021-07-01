package TestSmoke.старые_кейсы.разделы_меню.детям;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_01_Отображение_баннерной_зоны extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Отображение баннерной зоны")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void displayingBannerZone() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBannersCarousel();
    }
}
