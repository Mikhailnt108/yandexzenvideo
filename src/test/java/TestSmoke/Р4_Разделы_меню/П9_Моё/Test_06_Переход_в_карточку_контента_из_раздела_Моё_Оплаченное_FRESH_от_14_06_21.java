package TestSmoke.Р4_Разделы_меню.П9_Моё;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_06_Переход_в_карточку_контента_из_раздела_Моё_Оплаченное_FRESH_от_14_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Переход в карточку контента из раздела Моё_Оплаченное")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "102")
    public void goToContentCardFromMyMyPagePurchases() {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.paymentFilmAtEst();
        myPage.goToMyPagePurchases();
        myPage.clickToTailCardFilmFromPurchases();
        cardFilm.checkOpenCardFilm();
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
