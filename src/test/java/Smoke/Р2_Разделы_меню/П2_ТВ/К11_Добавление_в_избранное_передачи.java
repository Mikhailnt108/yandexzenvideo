package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К11_Добавление_в_избранное_передачи extends TestBase {
    @Test
    public void AddingTvProgramToFavorites() {
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
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.clickButtonFavorites();
        headerMenu.goToMyPageFavorites();
        myPage.checkAddingTvProgramToFavorites();


    }
}
