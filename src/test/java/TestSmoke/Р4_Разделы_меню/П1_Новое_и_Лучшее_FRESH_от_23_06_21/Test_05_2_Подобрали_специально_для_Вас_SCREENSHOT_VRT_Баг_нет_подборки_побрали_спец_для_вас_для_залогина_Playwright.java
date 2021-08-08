package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_05_2_Подобрали_специально_для_Вас_SCREENSHOT_VRT_Баг_нет_подборки_побрали_спец_для_вас_для_залогина_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Подобрали специально для вас (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void collectionSpecialForYou() throws Exception {
        // не авторизованный пользователь:
        niLPagePW.checkImageBlockCollectionSpecialForYou();
        // авторизованный пользователь:
        headerMenuPW.goToNilPage();
        flowRegistation();
        niLPagePW.checkImageBlockCollectionSpecialForYou();
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

