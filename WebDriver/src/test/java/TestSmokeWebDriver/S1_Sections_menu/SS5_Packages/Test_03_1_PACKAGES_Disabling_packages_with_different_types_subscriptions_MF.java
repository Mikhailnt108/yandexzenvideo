package TestSmokeWebDriver.S1_Sections_menu.SS5_Packages;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_1_PACKAGES_Disabling_packages_with_different_types_subscriptions_MF extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "7. Packages")
    @DisplayName(value ="Отключение пакетов с разными типами подписок for MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void disablingPackagesDifferentSubscriptionTypes() throws InterruptedException {
        // пользователь МФ:
        headerMenu.goToPackagesPage();
        flowRegistationMF();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();
        cardPackage.disablePackageTnB();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageSubs1();
        cardPackage.paymentPackageSubs1();
        cardPackage.disablePackageSubs1();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackageSubsN();
        cardPackage.paymentPackageSubsN();
        cardPackage.disablePackageSubsN();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistationMF() throws InterruptedException {
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
