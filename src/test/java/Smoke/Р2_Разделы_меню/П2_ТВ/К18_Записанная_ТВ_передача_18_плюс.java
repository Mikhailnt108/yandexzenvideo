package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К18_Записанная_ТВ_передача_18_плюс extends TestBase {
    @Test
    public void recordedEarlierTvProgram18Plus() throws Exception {
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
        cardPackage.chooseRecordedTvChannel18Plus();
        cardPackage.goToTvProgram18Plus();
        cardTvProgram.clickYesInPopUp18Plus();
        cardTvProgram.goToCardTvProgram18Plus();
        cardTvProgram.clickNoInPopUp18Plus();
    }
}
