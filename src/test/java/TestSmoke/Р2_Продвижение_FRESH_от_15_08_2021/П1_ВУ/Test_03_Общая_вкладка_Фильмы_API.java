package TestSmoke.Р2_Продвижение_FRESH_от_15_08_2021.П1_ВУ;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#3")
public class Test_03_Общая_вкладка_Фильмы_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "1. ВУ")
    @DisplayName(value = "Общая вкладка Фильмы")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void popUpNotificationFilterPageFilms() {
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOffer.archivePersonalOfferPartnerOfferOkkoTvForMF();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        popUpNotification.createAndPublishedPopUpNotifScreenFilms();
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.checkAbsencePopUpNotifToNilPage();
        headerMenu.goToFilmsPage();
        popUpNotification.checkElementsPopUpNotifScreenFilms();
        popUpNotification.deletePopUpNotifScreenFilms();
        pageCMS.deleteAccountMF("79260205027");

    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForAPINotif();
    }
}
