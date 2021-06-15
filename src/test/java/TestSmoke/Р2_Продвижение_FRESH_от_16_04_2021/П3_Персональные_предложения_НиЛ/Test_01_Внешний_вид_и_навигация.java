package TestSmoke.Р2_Продвижение_FRESH_от_16_04_2021.П3_Персональные_предложения_НиЛ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;

public class Test_01_Внешний_вид_и_навигация extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "Внешний вид и навигация")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceAndNavigation() {
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        headerMenu.goToNilPage();
        flowRegistation();
        personalOffer.checkElementsOnePersonalOffer();
        headerMenu.goToKidsPage();
        headerMenu.goToNilPage();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }

}
