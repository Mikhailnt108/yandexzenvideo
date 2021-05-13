package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_15_1_Незаписываемая_ТВ_передача_18_плюс_FRESH_от_10_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Незаписываемая ТВ передача 18 плюс")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(5)
    public void unrecordedTvProgram18Plus() throws Exception {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackage18Plus();
        cardPackage.checkOpenCardPackage18Plus();
        cardPackage.chooseUnrecordedTvChannel18Plus();
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
        //переключение на соседнюю передачу 18+ внутри плеера:
        cardTvProgram.swithOtherTvChannelInsidePlayer();
        cardTvProgram.checkAbsentPopUp18plus();
        //переключение c передачи 18+ на передачу НЕ 18+ внутри плеера:
        cardTvProgram.swithOnTvProgramNon18plusInsidePlayer();
        //переключение c передачи НЕ 18+ на передачу 18+ внутри плеера:
        cardTvProgram.swithOnTvProgram18PlusInsidePlayer();
        cardTvProgram.checkOpenPopUp18plus();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
    
}
