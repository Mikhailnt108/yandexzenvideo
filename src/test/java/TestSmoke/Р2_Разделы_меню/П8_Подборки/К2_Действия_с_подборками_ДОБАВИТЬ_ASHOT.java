package TestSmoke.Р2_Разделы_меню.П8_Подборки;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Действия_с_подборками_ДОБАВИТЬ_ASHOT extends TestBase {
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
        pageCMS.deleteAccount();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
