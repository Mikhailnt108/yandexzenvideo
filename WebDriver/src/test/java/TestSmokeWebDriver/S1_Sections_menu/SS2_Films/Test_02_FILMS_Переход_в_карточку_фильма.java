package TestSmokeWebDriver.S1_Sections_menu.SS2_Films;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_FILMS_Переход_в_карточку_фильма extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Переход в карточку фильма")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#1")
    public void goToCardFilm() throws InterruptedException {
        headerMenu.goToFilmsPage();
        filmsPage.switchingFromBannerToCardFilm();
        cardFilm.checkOpenCardFilm();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.checkOpenCardFilm();
        filmsPage.clickToLinkAllOnCollectionBlock();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
