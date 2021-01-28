package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_14_Переход_в_карточку_передачи_из_Программы_передач extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "14. Переход в карточку передачи из Программы передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void openCardTvProgramFromTabSchedule() {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickToTailTvChannel();
        cardTvProgram.checkOpenCardTvProgram();
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
