package TestSmoke.Р4_Разделы_меню.П7_Пакеты;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Переход_по_вкладкам_Пакеты_FRESH_от_04_06_21_изменены_табы_пакетов_для_ПП5 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value = "Переход по вкладкам Пакеты")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id="8")
    public void goToTabPackage() {
        headerMenu.goToPackagesPage();
//        headerMenu.checkNotLoggedIsCorrect();
//        packagesPage.checkTabAllServiceInMenuShopPage();
//        packagesPage.clickToTabAllPackage();
//        packagesPage.checkTabAllPackagesInMenuShopPage();
        packagesPage.clickToTabTvСhannelInMenuShopPage();
        packagesPage.checkTypePackagesInTabTvChannel();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.checkTypePackagesInTabSerials();
        packagesPage.clickToTabKinoInMenuShopPage();
        packagesPage.checkTypePackagesInTabKino();
        packagesPage.clickToTabMixedInMenuShopPage();
        packagesPage.checkTypePackagesInTabMixed();
        packagesPage.checkNotDisplayedTabConnectedInMenuShopPage();
        flowRegistation();
        packagesPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();
        headerMenu.goToPackagesPage();
        packagesPage.checkDisplayedTabConnectedInMenuShopPage();
        packagesPage.clickToTabConnectedInMenuShopPage();
        packagesPage.checkTypePackagesInTabConnectedInMenuShopPage();
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
