package TestSmokeWebDriver.S1_Sections_menu.SS5_Packages;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_PACKAGES_Subscription_to_package_by_SubsPromo_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Подписка на пакет по SubsPromo")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void subscribeToPackageBySubsPromo() throws Exception {
        // пользователь МФ, сервис по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationMF();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTabAllServices();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.checkElementsPopUpSubsPromoServiceForMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoService();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.clickOnButtonAcceptAndConfirm();
        cardPackage.checkElementsPopUpСonnectionСompleted();
        cardPackage.clickOnButtonClosePoUpСonnectionСompleted();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.startVideoPleer();

        // пользователь МФ, пакет по SubsPromo:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.checkElementsPopUpSubsPromoPackageForMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoPackage();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.clickOnButtonСonfirm();
        cardPackage.checkElementsPopUpСonnectionСompleted();
        cardPackage.clickOnButtonClosePoUpСonnectionСompleted();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.startVideoPleer();
        pageCMS.deleteAccountMF("79260172279");

        // пользователь НЕ МФ, сервис по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationNonMF();
        packagesPage.clickToTabAllServices();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.checkElementsPopUpSubsPromoServiceForNonMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoService();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.clickOnButtonAcceptAndConfirm();
        cardPackage.inputDataBankCard("4847 0000 6602 5312","12 / 25","258"); // тестовая банк карта
        cardPackage.checkElementsPopUpСonnectionСompleted();
        cardPackage.clickOnButtonClosePoUpСonnectionСompleted();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.startVideoPleer();

        // пользователь НЕ МФ, пакет по SubsPromo:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.checkElementsPopUpSubsPromoPackageForNonMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoPackage();
        cardPackage.clickOnPaymentButtonInCardPackageForUser();
        cardPackage.clickOnButtonConnect();
        cardPackage.checkElementsPopUpСonnectionСompleted();
        cardPackage.clickOnButtonClosePoUpСonnectionСompleted();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.startVideoPleer();
        pageCMS.deleteAccountNonMF("79261184972");
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
