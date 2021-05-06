package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
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
        packagesPage.clickToTailCardPackage18Plus();
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
