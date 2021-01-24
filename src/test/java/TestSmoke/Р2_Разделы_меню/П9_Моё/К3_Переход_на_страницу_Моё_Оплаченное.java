package TestSmoke.Р2_Разделы_меню.П9_Моё;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Переход_на_страницу_Моё_Оплаченное extends TestBase {
    @Test
    public void goToMyPagePurchases() {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.paymentPackageTnB();
        headerMenu.goToMyPagePurchases();
        myPage.goToCollectionPurchasesPage();
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
