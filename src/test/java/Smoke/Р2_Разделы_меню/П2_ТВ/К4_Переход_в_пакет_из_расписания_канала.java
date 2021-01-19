package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К4_Переход_в_пакет_из_расписания_канала extends TestBase {
    @Test
    public void openCardPackageFromScheduleChannel() {
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvChannel.clickToLinkCardPackage();
        cardPackage.checkOpenCardPackageTvChannel();


    }
}




