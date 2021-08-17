package TestSmoke.Р4_Разделы_меню.П7_Пакеты_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_05_Подписка_на_пакет_по_SubsN_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Подписка на пакет по SubsN")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void subscribeToPackageBySubsN() throws Exception {
        // пользователь НЕ МФ, пакет по SubsPromo:
        headerMenu.goToPackagesPage();
        flowRegistationNonMF();
        packagesPage.clickToTailCardPackageSubsN();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageSubsNForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258"); // тестовая банк карта
        cardPackage.chooseToTabFilms();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.ifAbsentOfferInPopUp();
        cardFilm.acceptOfferInPopUp();
        pageCMS.deleteAccountNonMF("79261184972");
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
