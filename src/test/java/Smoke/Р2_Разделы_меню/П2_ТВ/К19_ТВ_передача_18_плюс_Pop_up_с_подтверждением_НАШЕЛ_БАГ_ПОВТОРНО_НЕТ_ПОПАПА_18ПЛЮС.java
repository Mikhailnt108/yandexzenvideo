package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К19_ТВ_передача_18_плюс_Pop_up_с_подтверждением_НАШЕЛ_БАГ_ПОВТОРНО_НЕТ_ПОПАПА_18ПЛЮС extends TestBase {
    @Test
    public void PopUp18Plus() throws Exception {
        headerMenu.goToTvPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabNews();
        tvPage.checkСhannelsСorrespondGenresNews();
        cardTvChannel.chooseTvChannel18Plus();
        cardTvChannel.clickNoInPopUp18Plus();
        cardTvChannel.chooseTvChannel18Plus();
        cardTvChannel.clickYesInPopUp18Plus();
        cardTvChannel.chooseTvChannelNews();
        cardTvChannel.clickNoInPopUp18Plus();
        cardTvChannel.chooseTvChannel18Plus();
        cardTvChannel.clickYesInPopUp18Plus();
    }
}