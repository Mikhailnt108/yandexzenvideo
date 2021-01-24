package TestSmoke.Р2_Разделы_меню.П7_Пакеты;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Отключение_пакетов_с_разными_типами_подписок extends TestBase {
    @Test
    public void disablingPackagesDifferentSubscriptionTypes() {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();
        cardPackage.disablePackageTnB();
        cardPackage.paymentPackageSubs1();
        cardPackage.disablePackageSubs1();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageSubsN();
        cardPackage.paymentPackageSubsN();
        cardPackage.disablePackageSubsN();
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
