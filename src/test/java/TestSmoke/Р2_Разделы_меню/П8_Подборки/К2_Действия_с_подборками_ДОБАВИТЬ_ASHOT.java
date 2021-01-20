package TestSmoke.Р2_Разделы_меню.П8_Подборки;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Действия_с_подборками_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void actionsWithCollections() {
        headerMenu.goToAllCollectionsPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        allCollectionsPage.clickToTailCollection();
        collectionPage.clickToTailFilm();
        headerMenu.goToAllCollectionsPage();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionForKids();
        collectionPage.checkOpenCollectionPage();

    }
}
