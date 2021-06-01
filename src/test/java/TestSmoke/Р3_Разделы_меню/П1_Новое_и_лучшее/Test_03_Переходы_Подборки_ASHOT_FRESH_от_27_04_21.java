package TestSmoke.Р3_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_03_Переходы_Подборки_ASHOT_FRESH_от_27_04_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Подборки")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToCollection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkImageDifferBlocksCollection();
        nilPage.checkElementsCollection();
        nilPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        headerMenu.goToNilPage();
        nilPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToNilPage();
        nilPage.clickToTailCardTvProgram();
        cardTvChannel.checkOpenCardTvProgram();
        headerMenu.goToNilPage();
        nilPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllOnCollectionBlock();
        collectionPage.checkOpenCollectionPage();
        collectionPage.checkImageDifferPageCollection();
        collectionPage.checkElementsCollection();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionFilms();
        cardFilm.checkOpenCardFilm();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionTvProgram();
        cardTvChannel.checkOpenCardTvProgram();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionPackage();
        cardPackage.checkOpenCardPackage();
    }
}
