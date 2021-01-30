package TestSmoke.Р1_Авторизация_и_регистрация;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_8_Авторизация_из_карточки_Фильма extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Авторизация из карточки Фильма")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Order(8)
    public void loginFromCardFilm() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabFilms();
        filmsPage.checkOpenFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickPaymentButtonInCardFilm();
        flowAutorisation();
        pageCMS.deleteAccount();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        //headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }

    private void flowAutorisation() {
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
