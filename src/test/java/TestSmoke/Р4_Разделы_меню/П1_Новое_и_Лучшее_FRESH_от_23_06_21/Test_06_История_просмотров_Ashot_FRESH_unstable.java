package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_06_История_просмотров_Ashot_FRESH_unstable extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "История просмотров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void historyViewing() throws Exception {
        headerMenu.goToPackagesPage();
        flowRegistation();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTailCardPackageTnB();
        cardPackage.checkOpenCardPackage();
        cardPackage.paymentPackageTnB();

        //проверка отображения фильма в подборке:
        cardPackage.clickOnTailFirstCardFilm();
        cardFilm.moveSliderRewindToVideoPleer();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailCardFilmInCollectHistoryWatch();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkTimeStopPleer();
        nilPage.checkToMoveTileToFirstPlace();

        //скриншот тайла смотреть и редактировать:
//        nilPage.checkImageDifferTailWatchAndEditInCollectHistoryWatch();

        //проверка отображения сериала в подборке:
        headerMenu.goToPackagesPage();
        packagesPage.goToCardPackageTnBFlow();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailCardSerialInCollectHistoryWatch();
        cardSerial.checkOpenCardSerial();
        cardSerial.checkTimeStopPleerAndAutoStartPlayer();
        nilPage.checkToMoveTileToFirstPlace();

        //проверка отображения тв передачи в подборке:
        headerMenu.goToPackagesPage();
        packagesPage.goToCardPackageTnBFlow();
        cardPackage.clickOnTailCardChannel();
        cardTvChannel.clickTvProgramRecordInCardTvChannel();
        cardTvProgram.moveSliderRewindToVideoPlayer();
        headerMenu.goToNilPage();
        nilPage.checkAndClickOnTailCardTvProgramInCollectHistoryWatch();

        //проверка отсутствия эротического контента в подборке:
        //тв передача 18+:
        headerMenu.goToPackagesPage();
        packagesPage.clickToTabAllPackage();
        packagesPage.clickToTailCardPackage18Plus();
        cardPackage.paymentPackageTnB();
        cardPackage.clickOnTailCardChannel18Plus();
        cardTvChannel.clickTvProgramRecordInCardTvChannel();
        cardTvProgram.moveSliderRewindToVideoPlayer();
        headerMenu.goToNilPage();
        nilPage.checkAbsentTvProgram18PlusInCollectHistoryWatch();
//
//        //сериал 18+:
        headerMenu.goToPackagesPage();
        packagesPage.goToCardPackage18PlusFlow();
        cardPackage.clickToFirstTailCardSerial();
        cardSerial.moveSliderRewindToVideoPleer18Plus();
        headerMenu.goToNilPage();
        nilPage.checkAbsentSerial18PlusInCollectHistoryWatch();
//
//        //фильм 18+:
        headerMenu.goToPackagesPage();
        packagesPage.goToCardPackage18PlusFlow();
        cardPackage.clickOnTailFirstCardFilm18Plus();
        cardFilm.moveSliderRewindToVideoPleer18Plus();
        headerMenu.goToNilPage();
        nilPage.checkAbsentFilm18PlusInCollectHistoryWatch();

        //скриншоты и переходы:
        headerMenu.goToNilPage();
        nilPage.checkElementsBlockCollectHistoryWatch();
//        nilPage.checkImageDifferBlockCollectHistoryWatch();
        nilPage.clickToAllOnBlockCollectHistoryWatch();
        myPage.checkOpenPageMyHistory();
        myPage.checkVisibleContent18Plus();
        nilPage.checkAndClickOnTailWatchAndEdit();
        myPage.checkOpenPageMyHistory();
        myPage.checkVisibleContent18Plus();
        myPage.clickToButtonClearAllHistory();
        headerMenu.goToNilPage();
        nilPage.checkAbsentBlockCollectHistoryWatch();
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
