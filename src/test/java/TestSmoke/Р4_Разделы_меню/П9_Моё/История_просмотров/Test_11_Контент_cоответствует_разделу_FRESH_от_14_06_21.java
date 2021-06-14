package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_11_Контент_cоответствует_разделу_FRESH_от_14_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value = "Контент cоответствует разделу")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void contentСorrespondsToSection() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();
        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();
        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();

        // просмотр фильма из подключенного пакета:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.clickToTabFilms();
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.moveSliderRewindToVideoPleer();

        // просмотр сериала 18+:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackage18Plus();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToTabSerials();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer18Plus();

        // чек контент - только сериалы без 18+ в подборке продолжить просмтор:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.checkContentOnlySerialsWithout18Plus();
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
