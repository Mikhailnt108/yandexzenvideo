package TestSmokeWeb.Р4_Разделы_меню.П1_Новое_и_Лучшее_adWeb;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_1_Подобрали_специально_для_Вас_Баг_обрывается_подборка_побрали_спец_для_вас_adWeb extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Подобрали специально для Вас")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void collectionSpecialForYou() throws Exception {
        //пользователь НЕ авторизован:
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
        nilPage.checkElementsBlockCollectionSpecialForYou();
        nilPage.clickToTailContentCollectionSpecialForYou();
        headerMenu.goToNilPage();

        nilPage.clickToLinkAllWithCollectionSpecialForYou();
        collectionsPage.checkOpenCollectionPageForKids();
        collectionsPage.clickToTailContentOnPageCollect();
        headerMenu.goToNilPage();
        headerMenu.scrollDownPage();
        nilPage.scrollСollectionToRightInBlockCollectionSpecialForYou();
        nilPage.checkLastTailInCollectionSpecialForYou();
        nilPage.clickToLastTailInCollectionSpecialForYou();
        ratingPage.checkOpenRatingPage();
        headerMenu.goToNilPage();
        //пользователь авторизован:
        headerMenu.goToNilPage();
        flowRegistation();
        nilPage.checkElementsBlockCollectionSpecialForYou();
        nilPage.clickToTailContentCollectionSpecialForYou();
        headerMenu.goToNilPage();

        nilPage.clickToLinkAllWithCollectionSpecialForYou();
        collectionsPage.checkOpenCollectionPageForKids();
        collectionsPage.clickToTailContentOnPageCollect();
        headerMenu.goToNilPage();

        nilPage.scrollСollectionToRightInBlockCollectionSpecialForYou();
        nilPage.checkLastTailInCollectionSpecialForYou();
        nilPage.clickToLastTailInCollectionSpecialForYou();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
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

