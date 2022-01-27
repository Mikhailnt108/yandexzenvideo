package TestSmokeWebDriver.S1_Sections_menu.SS7_MY;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_06_MY_Transition_on_card_content_from_my_purchase extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "9. MY")
    @DisplayName(value ="Transition_on_card_content_from_my_purchase")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("31542105")
    @Test
    @Tag("SuiteWD#3")
    public void goToContentCardFromMyMyPagePurchases() throws InterruptedException {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.paymentFilmAtEst();
        myPage.goToMyPagePurchases();
        myPage.clickToTailCardFilmFromPurchases();
        cardFilm.checkOpenCardFilm();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
