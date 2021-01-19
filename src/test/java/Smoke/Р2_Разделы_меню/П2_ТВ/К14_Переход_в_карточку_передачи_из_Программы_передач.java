package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К14_Переход_в_карточку_передачи_из_Программы_передач extends TestBase {
    @Test
    public void openCardTvProgramFromTabSchedule() {
        headerMenu.goToTvPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickToTailTvChannel();
        cardTvProgram.checkOpenCardTvProgram();
    }
}
