package TestSmokeWebDriver.S1_Sections_menu.SS5_Packages;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Example2", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_PACKAGES_Transition_on_tabs extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "7. Packages")
    @DisplayName(value = "Transition_on_tabs_packages")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("31542083")
    @Test
    @Tag("Example2")
    public void goToTabPackage() throws InterruptedException {
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabTvСhannelInMenuShopPage();
        packagesPage.checkTypePackagesInTabTvChannel();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.checkTypePackagesInTabSerials();
        packagesPage.clickToTabKinoInMenuShopPage();
        packagesPage.checkTypePackagesInTabKino();
        packagesPage.clickToTabMixedInMenuShopPage();
        packagesPage.checkTypePackagesInTabMixed();
        packagesPage.checkNotDisplayedTabConnectedInMenuShopPage();
        flowRegistation();
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();
        headerMenu.goToPackagesPage();
        packagesPage.checkDisplayedTabConnectedInMenuShopPage();
        packagesPage.clickToTabConnectedInMenuShopPage();
        packagesPage.checkTypePackagesInTabConnectedInMenuShopPage();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
