package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Переход_в_карточку_фильма_FRESH_от_25_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Переход в карточку фильма")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "39")
    public void goToCardFilm() {
        headerMenu.goToFilmsPage();
        filmsPage.switchingFromBannerToCardFilm();
        cardFilm.checkOpenCardFilm();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        filmsPage.clickToLinkAllOnCollectionBlock();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
