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
public class Test_09_1_SERIALS_Choose_episode_from_block_episode extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value ="Select_episode_from_block_episode")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("35669382")
    @Test
    @Tag("SuiteWD#2")
    public void chooseEpisodeFromBlockEpisodes() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.chooseSeasonsMoreOneSeason();
        cardSerial.checkOpenCardSerial();
        cardSerial.checkElementsBlockEpisodes();
        cardSerial.clickTailEpisode();
        flowRegistation();
        headerMenu.refreshPage();
        cardSerial.clickTailEpisode();
        cardSerial.checkOpenPopUpPayment();
        cardSerial.paymentSerialAtSubsInPoUp();
        cardSerial.clickTailEpisodeForStartVideoPleer();
        cardSerial.chooseOtherSeasonAndCheckPoster();
//        cardSerial.scrollBlockEpisode();
        pageCMS.deleteAccountMF("79250110166");


    }
    private void flowRegistation() throws InterruptedException {
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
