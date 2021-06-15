package TestSmoke.Р4_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_05_Подобрали_специально_для_Вас_ASHOT_Баг_обрывается_лента_подборки_спешл_D extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Подобрали специально для Вас")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "20")
    public void collectionSpecialForYou() throws Exception {
        // не авторизованный пользователь:
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
        nilPage.checkImageDifferBlockCollectionSpecialForYou();
        nilPage.checkElementsBlockCollectionSpecialForYou();
        nilPage.clickToTailContentCollectionSpecialForYou();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionSpecialForYou();
        collectionsPage.checkOpenCollectionPage();
        collectionsPage.clickToTailContentOnPageCollect();
        headerMenu.goToNilPage();
        nilPage.scrollСollectionToRightInBlockCollectionSpecialForYou();
        headerMenu.goToNilPage();
        // авторизованный пользователь:
        headerMenu.goToNilPage();
        flowRegistation();
        nilPage.checkImageDifferBlockCollectionSpecialForYou();
        nilPage.checkElementsBlockCollectionSpecialForYou();
        nilPage.clickToTailContentCollectionSpecialForYou();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionSpecialForYou();
        collectionsPage.checkOpenCollectionPage();
        collectionsPage.clickToTailContentOnPageCollect();
        headerMenu.goToNilPage();
        nilPage.scrollСollectionToRightInBlockCollectionSpecialForYou();
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
