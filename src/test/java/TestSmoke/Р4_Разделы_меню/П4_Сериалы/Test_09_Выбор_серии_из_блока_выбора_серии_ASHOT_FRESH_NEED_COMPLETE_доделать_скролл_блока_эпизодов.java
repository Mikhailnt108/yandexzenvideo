package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_09_Выбор_серии_из_блока_выбора_серии_ASHOT_FRESH_NEED_COMPLETE_доделать_скролл_блока_эпизодов extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Выбор серии из блока выбора серии")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void chooseEpisodeFromBlockEpisodes() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.chooseSeasonsMoreOneSeason();
        cardSerial.checkOpenCardSerial();
//        cardSerial.checkImageDifferBlockEpisodes();
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
        pageCMS.deleteAccountMF("79260192144");


    }
    private void flowRegistation() {
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
