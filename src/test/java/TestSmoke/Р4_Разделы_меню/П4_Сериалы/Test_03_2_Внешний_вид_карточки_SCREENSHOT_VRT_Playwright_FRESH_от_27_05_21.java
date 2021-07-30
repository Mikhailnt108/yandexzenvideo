package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_2_Внешний_вид_карточки_SCREENSHOT_VRT_Playwright_FRESH_от_27_05_21 extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "Внешний вид карточки (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionCardSerial() throws Exception {
        // неавторизованный пользователь:
        headerMenuPW.goToSerialsPage();
        serialsPagePW.clickToFirstTailCardSerial();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.checkAutoStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForUnauthorized();
        // авторизованный пользователь:
//        headerMenuPW.goToSerialsPage();
//        flowRegistation();
//        serialsPagePW.clickToFirstTailCardSerial();
//        cardSerialPW.checkOpenCardSerial();
//        cardSerialPW.subscribeToPackageSerials();
//        cardSerialPW.checkAutoStartTrailerPlayer();
//        cardSerialPW.checkImageCardSerialForAuthorized();
//        headerMenuPW.deleteAccountMF("79260192144");
//    }
//    private void flowRegistation() {
//        headerMenuPW.checkNotLoggedIsCorrect();
//        headerMenuPW.clickToEnter();
//        headerMenuPW.checkOpenPopUpInputPhone();
//        headerMenuPW.inputLogin("+7 926 019 21 44");
//        headerMenuPW.clickToNext();
//        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44" , "111111");
//        headerMenuPW.clickToComeIn("Войти");
//        headerMenuPW.checkOpenPopUpInputCode();
//        headerMenuPW.copyPasteCodMsisdn("79260192144");
//        headerMenuPW.clickToComeIn("Войти");
//        headerMenuPW.checkLoginUserIsCorrectFlowForMF();
//    }
    }
}
