package TestSmokeWeb.Р4_Разделы_меню.П6_Пакеты_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_04_Подписка_на_пакет_по_SubsPromo_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Подписка на пакет по SubsPromo")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
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
    private void flowRegistationMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
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
