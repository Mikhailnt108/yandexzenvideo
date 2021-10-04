package TestSmokeWebDriver.P4_Sections_menu.П1_Новое_и_Лучшее_adWeb;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_1_Переходы_Баннеры_FRESH_adWeb extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void goToBanner() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkElementsBanner();
        nilPage.switchingFromBannerToCardFilm();
        headerMenu.goToNilPage();
        nilPage.switchingFromBannerToCardSerial();
    }
}
