package TestSmoke.Р4_Разделы_меню.П7_Пакеты;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_04_Подписка_на_пакет_по_SubsPromo_FRESH_от_07_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Подписка на пакет по SubsPromo")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id="10")
    public void subscribeToPackageBySubsPromo() throws Exception {
        // пользователь МФ, сервис по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationMF();
        packagesPage.clickToTabAllServices();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.checkElementsPopUpSubsPromoServiceForMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoService();
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.clickOnButtonAcceptAndConfirm();
        cardPackage.checkElementsPopUpСonnectionСompleted();
        cardPackage.clickOnButtonClosePoUpСonnectionСompleted();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.startVideoPleer();

        // пользователь МФ, пакет по SubsPromo:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.checkElementsPopUpSubsPromoPackageForMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoPackage();
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.clickOnButtonСonfirm();
        cardPackage.checkElementsPopUpСonnectionСompleted();
        cardPackage.clickOnButtonClosePoUpСonnectionСompleted();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.startVideoPleer();
        pageCMS.deleteAccountMF("79260192144");

        // пользователь НЕ МФ, сервис по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationNonMF();
        packagesPage.clickToTabAllServices();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.checkElementsPopUpSubsPromoServiceForNonMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoService();
        cardPackage.clickOnPaymentButtonInCardPackage();
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
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.checkElementsPopUpSubsPromoPackageForNonMF();
        cardPackage.clickOnButtonCancel();
        cardPackage.checkClosePopUpSubsPromoPackage();
        cardPackage.clickOnPaymentButtonInCardPackage();
        cardPackage.clickOnButtonAddAndConnect();
        cardPackage.inputDataBankCard("4847 0000 6602 5312","12 / 25","258"); // тестовая банк карта
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
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
