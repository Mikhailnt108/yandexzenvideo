package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_8_Пролистывание_баннера extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "8. Пролистывание_баннера")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void SwitchingFromBannerToCardPackage() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.autoScrollBanners();
        kidsPage.scrollBannersToLeft();
        kidsPage.scrollBannersToRight();
    }
}
