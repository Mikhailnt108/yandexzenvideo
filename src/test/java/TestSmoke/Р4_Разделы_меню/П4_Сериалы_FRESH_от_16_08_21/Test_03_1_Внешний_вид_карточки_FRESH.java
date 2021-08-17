package TestSmoke.Р4_Разделы_меню.П4_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_1_Внешний_вид_карточки_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Внешний вид карточки")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionCardSerial() throws Exception {
        // неавторизованный пользователь:
        headerMenu.goToSerialsPage();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.checkAutoStartVideoPlayer();
        cardSerial.checkElementsCardSerial();

        // авторизованный пользователь:
        headerMenu.goToSerialsPage();
        flowRegistation();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.checkAutoStartVideoPlayer();
        cardSerial.checkElementsCardSerial();
        cardSerial.checkButtonFavoriteNotAdded();
        cardSerial.clickButtonFavorites();
        myPage.checkAddingSerialToFavorites();
        headerMenu.goToSerialsPage();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.clickToButtonReadDescription();
        cardSerial.checkOpenDescriptionAll();
        cardSerial.clickToButtonRollUp();
        cardSerial.checkRollUpDescription();
        cardSerial.clickToLikeButton();
        cardSerial.clickToDisLikeButton();
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
