package TestSmoke.старые_кейсы.разделы_меню.тв;

import base.TestBase;
import org.junit.jupiter.api.RepeatedTest;

public class Tech_selectors_swith_channel_inside_player extends TestBase {
    @RepeatedTest(1)
    public void unrecordedTvProgram18Plus() throws Exception {
        headerMenu.goToPackagesPage();
        flowAuthorization();
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackage18Plus();
        cardPackage.chooseUnrecordedTvChannel18Plus();
        cardTvChannel.goToTvProgram18Plus();
        //запуск плеера передачи 18+:
        cardTvProgram.clickYesInPopUp18Plus();
        //переключение c передачи 18+ на передачу НЕ 18+ внутри плеера:
        cardTvProgram.swithOnTvProgramNon18plusInsidePlayer();
        //переключение c передачи НЕ 18+ на передачу 18+ внутри плеера:
        cardTvProgram.swithOnUnrecordedTvChannel18PlusInsidePlayer();
        //переключение на соседнюю передачу 18+ внутри плеера:
        cardTvProgram.swithOtherTvChannelInsidePlayer();
        headerMenu.goToBack();
        cardTvProgram.clickYesInPopUp18Plus();
        cardTvProgram.swithOtherTvChannelInsidePlayer();
    }

    private void flowAuthorization() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
