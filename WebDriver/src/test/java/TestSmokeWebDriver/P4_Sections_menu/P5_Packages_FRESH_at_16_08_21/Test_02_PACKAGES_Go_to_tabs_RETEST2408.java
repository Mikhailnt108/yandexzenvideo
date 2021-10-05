package TestSmokeWebDriver.P4_Sections_menu.P5_Packages_FRESH_at_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_PACKAGES_Go_to_tabs_RETEST2408 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value = "2. Переход по вкладкам Пакеты")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2")
    public void goToTabPackage() {
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
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}