package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_8_Пролистывание_баннера extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Пролистывание баннера")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void SwitchingFromBannerToCardPackage() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.autoScrollBanners();
        kidsPage.scrollBannersToLeft();
        kidsPage.scrollBannersToRight();
    }
}
