package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_10_Выставление_оценки_ДОТОЧИТЬ_ПРОВЕРКУ_ЛАЙКОВ_НЕТ_ПРОВЕРКИ_СЧЕТЧИКОВ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "10. Выставление оценки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void ratingFilm() {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickToLikeButton();
        cardFilm.clickToDisLikeButton();
        pageCMS.deleteAccount();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
