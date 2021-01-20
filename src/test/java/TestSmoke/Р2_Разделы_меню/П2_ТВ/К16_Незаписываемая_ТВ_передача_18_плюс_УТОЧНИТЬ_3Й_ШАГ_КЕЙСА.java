package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К16_Незаписываемая_ТВ_передача_18_плюс_УТОЧНИТЬ_3Й_ШАГ_КЕЙСА extends TestBase {
    @Test
    public void unrecordedTvProgram18Plus() throws Exception {
        headerMenu.goToPackagesPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        packagesPage.choosePackage18Plus();
        cardPackage.checkOpenCardPackage18Plus();
        cardPackage.chooseUnrecordedTvChannel18Plus();
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
    }
    
}
