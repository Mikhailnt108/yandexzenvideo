package TestSmokeWebDriver.S1_Sections_menu.SS1_TV;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_15_2_TV_Записываемая_ТВ_передача_18_плюс extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="Записываемая ТВ передача 18 плюс")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#0")
    public void recordedTvProgram18Plus() throws Exception {
        headerMenu.goToTvPage();
        flowRegistation();
        headerMenu.goToPackagesPage();
        packagesPage.checkOpenShopPage();
        packagesPage.checkTabAllPackagesInMenuShopPage();
        packagesPage.clickToTailCardPackage18Plus();
        cardPackage.checkOpenCardPackage18Plus();
        cardPackage.chooseRecordedTvChannel18Plus();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        cardTvChannel.goToTvProgram18Plus();
        cardTvProgram.clickYesInPopUp18Plus();
        headerMenu.refreshPage();
        cardTvProgram.checkOpenPopUp18plus();
        cardTvProgram.clickNoInPopUp18Plus();
        cardTvProgram.clickOnPlayInPlayer();
        cardTvProgram.checkOpenPopUp18plus();
        //запуск плеера передачи 18+:
        cardTvProgram.clickYesInPopUp18Plus();
        //переключение на передачу 18+ внутри плеера:
//        cardTvProgram.swithOnRecordedTvChannel18PlusInsidePlayer();
//        cardTvProgram.checkAbsentPopUp18plus();
//        //переключение на передачу не 18+ внутри плеера:
//        cardTvProgram.swithOnTvProgramNon18plusInsidePlayer();
//        //переключение на соседнюю передачу 18+ внутри плеера:
//        cardTvProgram.swithOnRecordedTvChannel18PlusInsidePlayer2();
        pageCMS.deleteAccountMF("79250110212");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110212");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9250110212", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110212");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
    
}
