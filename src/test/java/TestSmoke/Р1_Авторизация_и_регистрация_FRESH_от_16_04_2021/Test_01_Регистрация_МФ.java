package TestSmoke.Р1_Авторизация_и_регистрация_FRESH_от_16_04_2021;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_Регистрация_МФ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Регистрация МФ")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id="2")
    public void registrationMF() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.checkElementsPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.checkActiveButtonNext();
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForCaseRegistrationMF("9260192144");
        headerMenu.checkElementsPopUpCreatePassword();
        headerMenu.inputLessThanSixSimbolPassword("111");
        headerMenu.checkDisabledButtonComeIn();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickUncheckCheckBox();
        headerMenu.checkDisabledButtonComeIn();
        headerMenu.clickToLinkOffer();
        headerMenu.checkOpenPageOffer();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickCheckCheckBox();
        headerMenu.checkActiveButtonComeIn();
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        headerMenu.checkElementsPopUpInputCode();
        headerMenu.inputInvalidCodeСonfirmation("1234");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkErrorMessage1();
        headerMenu.inputInvalidCodeMoreThanThreeTimes();
        headerMenu.checkElementsPopUpForInvalidCodeMoreThanThreeTimes();
        headerMenu.clickToButtonGetNewCode();
        headerMenu.checkElementsPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
