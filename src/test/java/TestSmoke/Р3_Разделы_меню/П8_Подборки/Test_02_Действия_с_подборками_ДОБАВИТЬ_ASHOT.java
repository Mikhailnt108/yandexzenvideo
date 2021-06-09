package TestSmoke.Р3_Разделы_меню.П8_Подборки;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_02_Действия_с_подборками_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="Действия с подборками")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void actionsWithCollections() throws IOException, InterruptedException {
        headerMenu.goToAllCollectionsPage();
//        allCollectionsPage.clickToTailCollection();
//        collectionsPage.checkImageDifferPageBlockCollection();
//        collectionsPage.clickToTailFilm();
//        cardFilm.checkOpenCardFilm();
        collectionsPage.selectCollectionForKids();
//        kidsPage.clickToHeaderCollectionForKids();
//        collectionsPage.checkOpenCollectionPage();
//        collectionsPage.clickToTailFilm();
//        cardFilm.checkOpenCardFilm();
//        pageCMS.deleteAccountMF("79260192144");
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
