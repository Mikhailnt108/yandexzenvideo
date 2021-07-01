package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_11_Добавление_в_избранное_сериала_FRESH_от_29_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Добавление в избранное сериала")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void AddingSeriesToFavorites() {
        headerMenu.goToSerialsPage();
        flowRegistation();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.checkButtonFavoriteNotAdded();
        cardSerial.clickButtonFavorites();
        myPage.checkAddingSerialToFavorites();
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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
