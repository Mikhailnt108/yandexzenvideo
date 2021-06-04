package TestSmoke.старые_кейсы.разделы_меню.детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_11_Переход_в_карточку_фильма_из_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переход в карточку фильма из подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCardFilmFromCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();


    }
}
