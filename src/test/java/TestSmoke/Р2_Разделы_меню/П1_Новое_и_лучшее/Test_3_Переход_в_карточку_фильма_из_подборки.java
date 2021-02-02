package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_3_Переход_в_карточку_фильма_из_подборки extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="Переход в карточку фильма из подборки")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    @Disabled
    public void goToCardFilmFromCollection(){
        headerMenu.goToNilPage();
        nilPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
