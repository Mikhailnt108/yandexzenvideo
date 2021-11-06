package TestSmokeWebDriver.P4_Sections_menu.P5_Packages_FRESH_at_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_PACKAGES_Go_to_package_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("CheckWithRobot")
    public void goToPackage() throws InterruptedException {
        headerMenu.goToPackagesPage();
        packagesPage.clickToFirstTailCardPackage();
        Thread.sleep(60000);
        cardPackage.checkOpenCardPackage();
        }
    }


