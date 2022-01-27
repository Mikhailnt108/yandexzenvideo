package TestSmokeWebDriver.S1_Sections_menu.SS5_Packages;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_PACKAGES_Transition_on_package extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "7. Packages")
    @DisplayName(value ="Transition_on_package")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542082")
    @Test
    @Tag("SuiteWD#3")
    public void goToPackage() throws InterruptedException {
        headerMenu.goToPackagesPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


