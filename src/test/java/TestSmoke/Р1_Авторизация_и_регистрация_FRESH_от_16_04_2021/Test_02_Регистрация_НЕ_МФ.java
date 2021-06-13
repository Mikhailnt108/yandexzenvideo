package TestSmoke.Р1_Авторизация_и_регистрация_FRESH_от_16_04_2021;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Регистрация_НЕ_МФ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Регистрация НЕ МФ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id="3")
    public void registrationNotMF()  {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.deleteAccountNonMF("79261184972");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputEmail("9261184972");
        headerMenu.checkElementsPopUpInputEmail();
        headerMenu.inputInvalidEmailInPopUp("mail@@yaru");
        headerMenu.checkDisabledButtonNext();
        headerMenu.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenu.checkActiveButtonNext();
        headerMenu.clickToCheckBoxInPopUpEmail();
        headerMenu.checkActiveButtonNext();
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForNonMF();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForNonMegafon();
    }
}

