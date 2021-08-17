package TestSmoke.Р4_Разделы_меню.П4_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_2_Внешний_вид_карточки_SCREENSHOT_PLAYER_VRT_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "Внешний вид карточки (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionCardSerial() throws Exception {
        headerMenuPW.goToSerialsPage();
        serialsPagePW.clickToTailCardSerial();
        cardSerialPW.checkStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForGuest();
        flowRegistation();
        cardSerialPW.subscribeToPackageSerials();
        cardSerialPW.checkStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForUser();
        headerMenuPW.deleteAccountMF("79260192144");
    }
    private void flowRegistation () {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
