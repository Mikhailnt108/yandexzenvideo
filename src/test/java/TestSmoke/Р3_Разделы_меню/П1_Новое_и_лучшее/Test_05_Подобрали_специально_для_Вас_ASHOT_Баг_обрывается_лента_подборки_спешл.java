package TestSmoke.Р3_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_05_Подобрали_специально_для_Вас_ASHOT_Баг_обрывается_лента_подборки_спешл extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Подобрали специально для Вас")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void collectionSpecialForYou() throws Exception {
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
//        nilPage.checkImageDifferBlockCollectionSpecialForYou();
        nilPage.checkElementsBlockCollectionSpecialForYou();
        nilPage.clickToTailContentCollectionSpecialForYou();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionSpecialForYou();
        collectionPage.checkOpenCollectionPage();
        collectionPage.clickToTailContentOnPageCollect();
        headerMenu.goToNilPage();
        nilPage.scrollСollectionToRightInBlockCollectionSpecialForYou();

    }
}
