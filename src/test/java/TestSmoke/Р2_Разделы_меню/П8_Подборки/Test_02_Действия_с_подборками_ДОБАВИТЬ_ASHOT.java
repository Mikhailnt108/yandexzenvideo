package TestSmoke.Р2_Разделы_меню.П8_Подборки;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Действия_с_подборками_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="Действия с подборками")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void actionsWithCollections() {
        headerMenu.goToAllCollectionsPage();
        headerMenu.checkNotLoggedIsCorrect();
        flowRegistation();
        allCollectionsPage.clickToTailCollection();
        collectionPage.clickToTailFilm();
        headerMenu.goToAllCollectionsPage();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionForKids();
        collectionPage.checkOpenCollectionPage();
        pageCMS.deleteAccountMF();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
