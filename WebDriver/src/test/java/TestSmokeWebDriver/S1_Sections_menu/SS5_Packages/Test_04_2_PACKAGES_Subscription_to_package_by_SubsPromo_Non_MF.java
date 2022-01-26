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
public class Test_04_2_PACKAGES_Subscription_to_package_by_SubsPromo_Non_MF extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "7. Packages")
    @DisplayName(value = "Subscription_to_package_by_SubsPromo_Non_MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void subscribeToPackageBySubsPromo() throws Exception {
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
//        cardPackage.inputDataTestBankCard("4847 0000 6602 5312", "12 / 25", "258"); // тестовая банк карта
        cardPackage.inputDataBankCard(); // боевая банк карта
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
        private void flowRegistationNonMF () throws InterruptedException {
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
            headerMenu.clickToNext("Далее");
            pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
            headerMenu.clickToComeIn("Войти");
            headerMenu.checkLoginUserIsCorrectFlowForMF();
        }
    }

