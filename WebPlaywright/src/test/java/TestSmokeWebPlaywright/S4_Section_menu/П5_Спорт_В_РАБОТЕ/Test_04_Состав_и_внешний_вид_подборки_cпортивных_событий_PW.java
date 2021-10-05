package TestSmokeWebPlaywright.S4_Section_menu.П5_Спорт_В_РАБОТЕ;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_Состав_и_внешний_вид_подборки_cпортивных_событий_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value = "4. Состав и внешний вид подборки cпортивных событий")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void compositionAndAppearanceCollections() throws Exception {

        headerMenuPW.goToSportPage();


    }
}
