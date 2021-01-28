package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_3_Переход_в_карточку_фильма_из_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Переход в карточку фильма из подборки")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void goToCardFilmFromCollection(){
        headerMenu.goToNilPage();
        nilPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
