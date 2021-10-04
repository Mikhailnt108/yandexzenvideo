package TestSmokeWebDriver.P4_Sections_menu.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_1_СЕРИАЛЫ_Внешний_вид_карточки_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="3.1 Внешний вид карточки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#4")
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
        pageCMS.deleteAccountMF("79250110166");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110166");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9250110166", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110166");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
