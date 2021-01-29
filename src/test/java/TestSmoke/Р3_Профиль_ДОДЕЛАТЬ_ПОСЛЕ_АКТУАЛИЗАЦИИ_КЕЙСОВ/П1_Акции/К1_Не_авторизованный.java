package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ.П1_Акции;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К1_Не_авторизованный extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Не авторизованный")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void notAuthorized() {
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
    }
}
