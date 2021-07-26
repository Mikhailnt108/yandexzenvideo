package TestSmoke.Р4_Разделы_меню.П2_ТВ_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_15_2_Записываемая_ТВ_передача_18_плюс_FRESH_от_29_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Записываемая ТВ передача 18 плюс")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void recordedTvProgram18Plus() throws Exception {
        headerMenu.goToNilPage();
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
        cardTvProgram.swithOnRecordedTvChannel18PlusInsidePlayer();
        cardTvProgram.checkAbsentPopUp18plus();
        //переключение на передачу не 18+ внутри плеера:
        cardTvProgram.swithOnTvProgramNon18plusInsidePlayer();
        //переключение на соседнюю передачу 18+ внутри плеера:
        cardTvProgram.swithOnRecordedTvChannel18PlusInsidePlayer2();
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
    
}
