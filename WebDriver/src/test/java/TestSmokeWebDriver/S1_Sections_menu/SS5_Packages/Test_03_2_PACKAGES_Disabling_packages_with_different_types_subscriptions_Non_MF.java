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
public class Test_03_2_PACKAGES_Disabling_packages_with_different_types_subscriptions_Non_MF extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Отключение пакетов с разными типами подписок for Non MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void disablingPackagesDifferentSubscriptionTypes() throws InterruptedException {
        // пользователь НЕ МФ:
        headerMenu.goToPackagesPage();
        flowRegistationNonMF();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
//        cardPackage.paymentPackageTnBForNonMfTestBankCardNotLinked("4847 0000 6602 5312", "12 / 25", "258"); // тестовая банк карта
        cardPackage.paymentPackageTnBForNonMfRealBankCardNotLinked("5106 2110 1024 3900","08 / 22","573"); // боевая банк карта
        cardPackage.disablePackageTnB();
        headerMenu.goToPackagesPage();
//        packagesPage.clickToTailCardPackageSubsN(); // для ПП1, ПП3 нет боевой карты для покупки SubsN
//        cardPackage.paymentPackageSubsNForNonMFBankCardLinked();
//        cardPackage.disablePackageSubsN();
        pageCMS.deleteAccountNonMF("79261184972");
    }

    private void flowRegistationNonMF() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputEmail("9261184972");
        headerMenu.checkElementsPopUpInputEmail();
        headerMenu.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationNonMF("9261184972", "111111");
        headerMenu.clickToComeIn("Войти");
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
