package TestSmoke.Р1_Авторизация_и_регистрация;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Регистрация_МФ_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Регистрация МФ")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void registrationMF()  {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.deleteAccountMF();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.checkElementsPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.checkActiveButtonNext();
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForMF("9260192144");
        headerMenu.checkElementsPopUpCreatePassword();
        headerMenu.inputLessThanSixSimbolPassword("1111");
        headerMenu.checkDisabledButtonComeIn();
        headerMenu.inputMoreThanSixAndUncheckCheckbox("111111");
        headerMenu.checkDisabledButtonComeIn();
        headerMenu.clickToLinkOffer();
        headerMenu.checkOpenPageOffer();
        headerMenu.inputMoreThanSixPasswordAndCheckCheckbox("111111");
        headerMenu.checkActiveButtonComeIn();
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        headerMenu.checkElementsPopUpInputCode();
        headerMenu.inputInvalidCodeСonfirmation("1234");
        headerMenu.checkErrorMessage1();
        headerMenu.inputInvalidCodeMoreThanThreeTimes();
        headerMenu.checkElementsPopUpForInvalidCodeMoreThanThreeTimes();
        headerMenu.clickToButtonGetNewCode();
        headerMenu.checkElementsPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
