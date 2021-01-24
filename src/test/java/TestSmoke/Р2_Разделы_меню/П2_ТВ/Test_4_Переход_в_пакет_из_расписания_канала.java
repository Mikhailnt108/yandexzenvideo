package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_4_Переход_в_пакет_из_расписания_канала extends TestBase {
    @Test
    public void openCardPackageFromScheduleChannel() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvChannel.clickToLinkCardPackage();
        cardPackage.checkOpenCardPackageTvChannel();
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




