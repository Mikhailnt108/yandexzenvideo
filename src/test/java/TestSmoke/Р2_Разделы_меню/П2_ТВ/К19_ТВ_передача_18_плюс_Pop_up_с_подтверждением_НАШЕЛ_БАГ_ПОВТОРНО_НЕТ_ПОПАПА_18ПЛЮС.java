package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К19_ТВ_передача_18_плюс_Pop_up_с_подтверждением_НАШЕЛ_БАГ_ПОВТОРНО_НЕТ_ПОПАПА_18ПЛЮС extends TestBase {
    @Test
    public void PopUp18Plus() throws Exception {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.choosePackage18Plus();
        cardPackage.checkOpenCardPackage18Plus();
        cardPackage.chooseRecordedTvChannel18Plus();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabNews();
        tvPage.checkСhannelsСorrespondGenresNews();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        cardTvChannel.clickToButtonPlay();
        cardTvChannel.chooseTvChannel18Plus();
        cardTvChannel.clickNoInPopUp18Plus();
        cardTvChannel.chooseTvChannel18Plus();
        cardTvChannel.clickYesInPopUp18Plus();
        cardTvChannel.chooseTvChannelNews();
        cardTvChannel.clickNoInPopUp18Plus();
        cardTvChannel.chooseTvChannel18Plus();
        cardTvChannel.clickYesInPopUp18Plus();
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