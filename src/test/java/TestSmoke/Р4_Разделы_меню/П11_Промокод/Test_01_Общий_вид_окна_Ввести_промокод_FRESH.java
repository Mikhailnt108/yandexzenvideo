package TestSmoke.Р4_Разделы_меню.П11_Промокод;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Общий_вид_окна_Ввести_промокод_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "11. Промокод")
    @DisplayName(value ="Общий вид окна Ввести_промокод")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "107")
    public void checkViewOfPromoCodePopUp() {
        headerMenu.goToNilPage();
        headerMenu.clickToButtonPromo();
        flowRegistation();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCode();
    }
    private void flowRegistation() {
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
