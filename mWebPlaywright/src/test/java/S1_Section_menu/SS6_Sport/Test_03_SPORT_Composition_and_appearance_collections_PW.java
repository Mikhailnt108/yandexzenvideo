package S1_Section_menu.SS6_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_SPORT_Composition_and_appearance_collections_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "6. Sport")
    @DisplayName(value = "03_SPORT_Composition_and_appearance_collections")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void SPORT_Composition_and_appearance_collections() throws Exception {
        headerMenuPW.goToSportPage();
        sportPagePW.checkImageBlockCollectionSportChannelsFofUser(); // добавить скриншот тесты
        sportPagePW.checkElementsBlockCollectionLiveBroadcastForUser();
        sportPagePW.checkImageBlockCollectionLiveBroadcastForUser(); // добавить скриншот тесты
        // пользователь авторизован:
        flowRegistationMF();
        headerMenuPW.goToSportPage();
        sportPagePW.checkImageBlockCollectionSportChannelsFofUser(); // добавить скриншот тесты
        sportPagePW.checkElementsBlockCollectionLiveBroadcastForUser();
        sportPagePW.checkImageBlockCollectionLiveBroadcastForUser(); // добавить скриншот тесты
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginNonAdmWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
