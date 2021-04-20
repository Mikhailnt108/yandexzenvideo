package TestSmoke.Р2_Продвижение_FRESH_от_16_04_2021.П1_ВУ;

import base.TestBase;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Test_01_Внешний_вид_всплывающего_уведомления extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "1. ВУ")
    @DisplayName(value = "Внешний вид и навигация")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedIfExceptionsTest(repeats = 2)
    public void appearanceOfPopUpNotification() {
        popUpNotification.createAndPublishedPopUpNotifScreenNilPayFilm();
        headerMenu.goToNilPage();
        flowRegistation();
        popUpNotification.checkElementsPopUpNotifScreenNilPayFilm();
        popUpNotification.deletePopUpNotifScreenNilPayFilm();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}

