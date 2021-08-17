package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_17_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_05_Аренда_фильма_за_деньги_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Аренда фильма за деньги")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void PaymentFilmForRent2() throws Exception {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToHeaderRent2Collection();
        collectionsPage.checkOpenCollectionRent2Page();
        collectionsPage.clickToTailFilmRent2();
        cardFilm.paymentButtonRent2InCardFilm();
        cardFilm.startVideoPleer();
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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
