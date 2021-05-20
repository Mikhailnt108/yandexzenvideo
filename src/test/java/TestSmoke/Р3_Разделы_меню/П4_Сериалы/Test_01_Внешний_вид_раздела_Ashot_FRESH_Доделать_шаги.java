package TestSmoke.Р3_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Внешний_вид_раздела_Ashot_FRESH_Доделать_шаги extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionSerialsPage() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsSerialsPage();
        serialsPage.checkImageDifferCherdakAndBanners();
        serialsPage.checkImageDifferBreadcrumbsAndBlocksFilters(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
        serialsPage.checkImageDifferBlocksCollection(); // на пп4 нет выпадушки "Сортировка" в форме фильтров
        serialsPage.checkImageDifferFooter();
        serialsPage.checkImageDifferSerialsPageScroll();
        flowRegistation();
        filmsPage.checkElementsFilmsPage();
        pageCMS.deleteAccountMF("79260192144");
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
