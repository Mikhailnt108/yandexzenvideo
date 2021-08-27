package TestSmokeWeb.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_06_1_НИЛ_История_просмотров_FRESH_unstable_Баг_не_отображается_тв_передача_в_подборке extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "История просмотров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void historyViewing() throws Exception {
        // подключение пакета:
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();

        // проверка отображения фильма в подборке:
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.moveSliderRewindToVideoPlayer();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailCardFilmInCollectHistoryWatch();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkTimeStopPlayer();
        nilPage.checkToMoveTileToFirstPlace();

        // проверка отображения сериала в подборке:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickToTabSerials();
        headerMenu.refreshPage();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.moveSliderRewindToVideoPlayer();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailCardSerialInCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
        cardSerial.checkTimeStopPlayer();
        nilPage.checkToMoveTileToFirstPlace();

        // проверка отображения тв передачи в подборке:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackageKinoPoPodpiske();
        cardPackage.clickOnTailCardChannel();
        cardTvChannel.clickTvProgramRecordInCardTvChannel();
        cardTvProgram.moveSliderRewindToVideoPlayer();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailCardTvProgramInCollectHistoryWatch();

        // проверка отсутствия эротического контента в подборке:
        // тв передача 18+:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackage18Plus();
        cardPackage.paymentPackageTnB();
        cardPackage.clickOnTailCardChannel18Plus();
        cardTvChannel.clickTvProgramRecordInCardTvChannel();
        cardTvProgram.moveSliderRewindToVideoPlayer();
        headerMenu.goToNilPage();
        nilPage.checkAbsentTvProgram18PlusInCollectHistoryWatch();

        // сериал 18+:
        headerMenu.goToPackagesPage();
        packagesPage.goToCardPackage18PlusFlow();
        cardPackage.clickToTabSerials();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer18Plus();
        headerMenu.goToNilPage();
        nilPage.checkAbsentSerial18PlusInCollectHistoryWatch();

        // фильм 18+:
        headerMenu.goToPackagesPage();
        packagesPage.goToCardPackage18PlusFlow();
        cardPackage.clickOnTailFirstCardFilm18Plus();
        cardFilm.moveSliderRewindToVideoPleer18Plus();
        headerMenu.goToNilPage();
        nilPage.checkAbsentFilm18PlusInCollectHistoryWatch();

        // чек подборки и переходы:
        headerMenu.goToNilPage();
        nilPage.checkElementsBlockCollectHistoryWatch();
        nilPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        myPage.checkVisibleContent18Plus();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
        myPage.checkVisibleContent18Plus();
        myPage.clickToButtonClearAllHistory();
        headerMenu.goToNilPage();
        nilPage.checkAbsentBlockCollectHistoryWatch();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowAuthorization() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.checkActiveButtonComeIn();
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
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
