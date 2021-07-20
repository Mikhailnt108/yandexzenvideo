package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_1_Переходы_Подборки_FRESH_Баг_не_отображаются_подборки_без_заголовка extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkElementsBlockCollectionWithHeader();
        nilPage.checkElementsBlockCollectionWithoutHeader();
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
        collectionsPage.checkOpenCollectionPage();
        collectionsPage.checkElementsPageBlockCollection();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionFilms();
        collectionsPage.clickToTailFilm();
        cardFilm.checkOpenCardFilm();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionSerial();
        collectionsPage.clickToTailSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionTvProgram();
        collectionsPage.clickToTailTvProgram();
        cardTvChannel.checkOpenCardTvProgram();
        headerMenu.goToNilPage();
        nilPage.clickToLinkAllWithCollectionPackage();
        collectionsPage.clickToTailPackage();
        cardPackage.checkOpenCardPackage();
    }
}
