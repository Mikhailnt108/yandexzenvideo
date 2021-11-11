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
public class Test_06_PACKAGES_Subscription_to_package_by_Subs1 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Подписка на пакет по Subs1")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void subscribeToPackageBySubs1() throws Exception {
        // пользователь МФ, пакет по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationMF();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();
        cardPackage.disablePackageTnB();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageSubs1();
        cardPackage.paymentPackageSubs1();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.startVideoPleer();
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
