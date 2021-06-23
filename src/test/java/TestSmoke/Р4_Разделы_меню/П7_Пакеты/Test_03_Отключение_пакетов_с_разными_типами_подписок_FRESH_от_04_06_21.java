package TestSmoke.Р4_Разделы_меню.П7_Пакеты;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_Отключение_пакетов_с_разными_типами_подписок_FRESH_от_04_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Отключение пакетов с разными типами подписок")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id="83")
    public void disablingPackagesDifferentSubscriptionTypes() {
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
        pageCMS.deleteAccountMF("79260192144");

        // пользователь НЕ МФ:
        headerMenu.goToPackagesPage();
        flowRegistationNonMF();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258"); // тестовая банк карта
        cardPackage.disablePackageTnB();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageSubsN();
        cardPackage.paymentPackageSubsNForNonMFBankCardLinked();
        cardPackage.disablePackageSubsN();
        pageCMS.deleteAccountNonMF("79261184972");
    }
    private void flowRegistationMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
    private void flowRegistationNonMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
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
