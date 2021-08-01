package TestSmoke.Р4_Разделы_меню.П9_Моё.История_просмотров;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_09_Кнопка_смотреть_Все_и_тайл_заглушка_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Кнопка смотреть Все и тайл заглушка")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void buttonAllWatchAndTailWatchAndEdit() throws Exception {
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
        // переходы в историю просмотра:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        headerMenu.goToSerialsPage();
        serialsPage.checkTailWatchAndEdit();
        serialsPage.clickToTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
        pageCMS.deleteAccountMF("79260192144");

        // пользователь НЕ МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.paymentPackageTnBForNonMFBankCardNotLinked("4847 0000 6602 5312","12 / 25","258");
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
        // переходы в историю просмотра:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        headerMenu.goToSerialsPage();
        serialsPage.checkTailWatchAndEdit();
        serialsPage.clickToTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
        pageCMS.deleteAccountNonMF("79261184972");
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
    private void flowRegistationNonMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputEmail("9261184972");
        headerMenu.checkElementsPopUpInputEmail();
        headerMenu.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationNonMF("9261184972", "111111");
        headerMenu.clickToComeIn("Войти");
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
