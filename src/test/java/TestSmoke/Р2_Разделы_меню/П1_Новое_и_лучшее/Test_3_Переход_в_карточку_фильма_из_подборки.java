package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_3_Переход_в_карточку_фильма_из_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="3. Переход в подборку")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void goToCardFilmFromCollection(){
        headerMenu.goToNilPage();
        nilPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
