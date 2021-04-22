package TestSmoke.Р3_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Аренда_фильма_за_деньги extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Аренда фильма за деньги")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void PaymentFilmForRent2() throws Exception {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToHeaderRent2Collection();
        collectionPage.checkOpenCollectionRent2Page();
        collectionPage.clickToTailFilmRent2();
        cardFilm.paymentButtonRent2InCardFilm();
        cardFilm.startVideoPleer();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() {
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
