package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_1_Отображение_баннерной_зоны_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Отображение баннерной зоны")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void displayingBannerZone() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBannersCarousel();
    }
}
