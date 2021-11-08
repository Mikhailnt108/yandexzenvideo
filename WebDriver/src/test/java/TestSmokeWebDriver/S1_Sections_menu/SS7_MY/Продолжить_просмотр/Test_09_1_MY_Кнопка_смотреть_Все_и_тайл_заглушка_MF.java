package TestSmokeWebDriver.S1_Sections_menu.SS7_MY.Продолжить_просмотр;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_1_MY_Кнопка_смотреть_Все_и_тайл_заглушка_MF extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="9. Кнопка смотреть Все и тайл заглушка for MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void buttonAllWatchAndTailWatchAndEdit() throws Exception {
        // пользователь МФ:
        // подключение пакет и просмотр первого сериала:
        headerMenu.goToPackagesPage();
        flowRegistationMF();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.paymentPackageTnB();
        cardPackage.clickToTabSerials();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();
        // просмотр второго сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToSecondTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();
        // просмотр третьего сериала:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToThirdTailCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();
        // переходы в историю просмотра:
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsBlockCollectHistoryWatch();
        serialsPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        headerMenu.goToSerialsPage();
        serialsPage.scrollToTailWatchAndEdit();
        serialsPage.clickToTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
        pageCMS.deleteAccountMF("79260172279");
    }

    private void flowRegistationMF() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
