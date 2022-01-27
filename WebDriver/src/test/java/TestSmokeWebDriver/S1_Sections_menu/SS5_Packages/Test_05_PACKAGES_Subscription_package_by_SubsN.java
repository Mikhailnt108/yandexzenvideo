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
public class Test_05_PACKAGES_Subscription_package_by_SubsN extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "7. Packages")
    @DisplayName(value ="Subscription_package_by_SubsN")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("35669384")
    @Test
    @Tag("SuiteWD#3")
    public void subscribeToPackageBySubsN() throws Exception {
        // пользователь НЕ МФ, пакет по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationNonMF();
        packagesPage.clickToTailCardPackageSubsN();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageSubsNForNonMFBankCardNotLinked(); // тестовая банк карта
        cardPackage.chooseToTabFilms();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.ifAbsentOfferInPopUp();
        cardFilm.acceptOfferInPopUp();
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
        headerMenu.clickToNext("Далее");
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
