package TestSmoke.Р2_Разделы_меню.П9_Моё;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К7_Переход_в_карточку_контента_из_раздела_Моё_Пакеты extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "7. Переход в карточку контента из раздела Моё Пакеты")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCardPackageFromMyPagePackages() {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.paymentPackageTnB();
        headerMenu.goToMyPageSubscriptions();
        myPage.clickToTailCardPackageFromSubscriptions();
        cardPackage.checkOpenCardPackage();
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
