package TestSmoke.старые_кейсы.профиль;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class К10_Не_авторизованный_СТАРЫЙ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "1. Акции")
    @DisplayName(value ="Не авторизованный")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void notAuthorized() {
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
    }
}
