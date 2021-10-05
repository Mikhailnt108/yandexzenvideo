package TestSmokeWebPlaywright.S4_Section_menu.П5_Спорт_В_РАБОТЕ;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_Состав_и_внешний_вид_подборок_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value = "3. Состав и внешний вид подборок")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void compositionAndAppearanceCollections() throws Exception {
        headerMenuPW.goToSportPage();
        sportPagePW.checkImageBlockCollectionSportChannelsFofUser(); // добавить скриншот тесты
        sportPagePW.checkElementsBlockCollectionLiveBroadcastForUser();
        sportPagePW.checkImageBlockCollectionLiveBroadcastForUser(); // добавить скриншот тесты
        // пользователь авторизован:
        flowRegistation();
        sportPagePW.checkImageBlockCollectionSportChannelsFofUser(); // добавить скриншот тесты
        sportPagePW.checkElementsBlockCollectionLiveBroadcastForUser();
        sportPagePW.checkImageBlockCollectionLiveBroadcastForUser(); // добавить скриншот тесты
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
