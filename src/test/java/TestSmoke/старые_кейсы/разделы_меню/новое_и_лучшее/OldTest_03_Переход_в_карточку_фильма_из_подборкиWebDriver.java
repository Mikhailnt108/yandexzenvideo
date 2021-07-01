package TestSmoke.старые_кейсы.разделы_меню.новое_и_лучшее;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OldTest_03_Переход_в_карточку_фильма_из_подборкиWebDriver extends TestBaseWebDriver {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="Переход в карточку фильма из подборки")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void goToCardFilmFromCollection(){
        headerMenu.goToNilPage();
        nilPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
