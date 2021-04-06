package TestSmoke.Р2_Разделы_меню.П7_Пакеты;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Переход_по_вкладкам_Пакеты extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value = "Переход по вкладкам Пакеты")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToTabPackage() {
        headerMenu.goToPackagesPage();
        headerMenu.checkNotLoggedIsCorrect();
        packagesPage.checkTabAllPackagesInMenuPackagesPage();
        packagesPage.checkTypePackagesInTabAll();
        packagesPage.checkAllPackegesWithoutOwnership();
        packagesPage.clickToTabTvСhannelInMenuShopPage();
        packagesPage.checkTypePackagesInTabTvChannel();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.checkTypePackagesInTabSerials();
        packagesPage.clickToTabKinoInMenuPackagesPage();
        packagesPage.checkTypePackagesInTabKino();
        packagesPage.clickToTabMixedInMenuPackagesPage();
        packagesPage.checkTypePackagesInTabMixed();
        packagesPage.checkNotDisplayedTabConnectedInMenuPackagesPage();
        flowRegistation();
        packagesPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();
        headerMenu.goToPackagesPage();
        packagesPage.checkDisplayedTabConnectedInMenuPackagesPage();
        packagesPage.checkConnectedOnTailPackage();
        packagesPage.clickToTabConnectedInMenuPackagesPage();
        packagesPage.checkTypePackagesInTabConnectedInMenuPackagesPage();
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
