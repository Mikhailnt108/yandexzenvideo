package TestSmokeWeb.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_1_Выбор_серии_из_блока_выбора_серии_FRESH_NEED_COMPLETE_доделать_скролл_блока_эпизодов_Баг_нет_трансляции_серии_Фитнес extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Выбор серии из блока выбора серии")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2Exp")
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
        pageCMS.deleteAccountMF("79260172279");


    }
    private void flowRegistation() {
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
