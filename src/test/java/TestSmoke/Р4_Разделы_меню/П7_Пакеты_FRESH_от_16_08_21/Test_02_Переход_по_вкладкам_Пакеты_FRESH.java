package TestSmoke.Р4_Разделы_меню.П7_Пакеты_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Переход_по_вкладкам_Пакеты_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value = "Переход по вкладкам Пакеты")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToTabPackage() {
        headerMenu.goToPackagesPage();
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
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
