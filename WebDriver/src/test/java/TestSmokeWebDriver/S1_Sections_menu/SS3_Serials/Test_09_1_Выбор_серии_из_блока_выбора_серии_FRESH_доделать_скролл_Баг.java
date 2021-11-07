package TestSmokeWebDriver.S1_Sections_menu.SS3_Serials;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_1_Выбор_серии_из_блока_выбора_серии_FRESH_доделать_скролл_Баг extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Выбор серии из блока выбора серии")
    @Severity(SeverityLevel.BLOCKER)
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
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110166");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
