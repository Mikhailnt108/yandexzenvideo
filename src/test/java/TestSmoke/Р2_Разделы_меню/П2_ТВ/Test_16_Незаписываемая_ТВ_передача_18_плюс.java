package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_16_Незаписываемая_ТВ_передача_18_плюс extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Незаписываемая ТВ передача 18 плюс")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void unrecordedTvProgram18Plus() throws Exception {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.choosePackage18Plus();
        cardPackage.checkOpenCardPackage18Plus();
        cardPackage.chooseUnrecordedTvChannel18Plus();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        cardPackage.goToTvProgram18Plus();
        cardTvProgram.clickYesInPopUp18Plus();
        cardTvProgram.goToCardTvProgram18Plus();
        cardTvProgram.clickNoInPopUp18Plus();
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabErotica();
        tvPage.checkUnrecordedСhannelsСorrespondGenres18Plus();
        cardTvProgram.clickYesInPopUp18Plus();
        headerMenu.goToTvPage();
        tvPage.clickOnTabErotica();
        tvPage.checkUnrecordedСhannelsСorrespondGenres18Plus();
        cardTvProgram.clickNoInPopUp18Plus();
        pageCMS.deleteAccount();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
    
}
