package TestSmokeWebDriver.S1_Sections_menu.SS3_Serials;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_1_SERIALS_Appearance_card_serial extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value ="Appearance_card_serial")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("35669381")
    @Test
    @Tag("SuiteWD#2")
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
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110166");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9250110166", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110166");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
