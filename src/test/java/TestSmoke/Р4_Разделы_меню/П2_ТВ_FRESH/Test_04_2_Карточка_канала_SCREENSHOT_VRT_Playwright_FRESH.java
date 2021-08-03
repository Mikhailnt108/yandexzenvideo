package TestSmoke.Р4_Разделы_меню.П2_ТВ_FRESH;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import java.io.IOException;

public class Test_04_2_Карточка_канала_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value = "Карточка канала (скринщоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void cardTvChannel() throws IOException, InterruptedException {
        // неавторизованный пользователь:
        сardTvChannelPW.checkImageCardTvChannelForUnauthorized();
        // авторизованный пользователь:
        headerMenuPW.goToNilPage();
        flowRegistation();
        сardTvChannelPW.checkImageCardTvChannelForAuthorized();
        headerMenuPW.deleteAccountMF("79260192144");
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44" , "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
