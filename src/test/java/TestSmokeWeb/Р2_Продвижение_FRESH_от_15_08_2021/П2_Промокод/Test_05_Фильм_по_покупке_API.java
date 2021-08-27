package TestSmokeWeb.Р2_Продвижение_FRESH_от_15_08_2021.П2_Промокод;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_Фильм_по_покупке_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "2. Промокод")
    @DisplayName(value = "Фильм по покупке")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3")
    public void filmOnEST() {
        promoCode.createAndPublishedRC();
        promoCode.createAndPublishedCodeGroupAndPromoCodeFilmOnEST();
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCode();
        headerMenu.inputValidPromoCode("promoCodeFilmOnEST");
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpBeforeActivation();
        headerMenu.checkElementsPopUpBeforeActivationFilmOnEST();
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpAfterActivation();
        headerMenu.checkElementsPopUpAfterActivationFilmOnEST();
        headerMenu.clickToButtonMoreDetailedAndCheckOpenCardFilmOnEST();
        promoCode.archiveCodeGroupFilmOnEST();
        pageCMS.deleteAccountMF("79260205027");
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
