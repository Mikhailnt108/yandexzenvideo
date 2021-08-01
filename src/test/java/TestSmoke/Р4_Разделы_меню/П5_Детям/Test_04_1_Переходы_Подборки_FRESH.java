package TestSmoke.Р4_Разделы_меню.П5_Детям;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_04_1_Переходы_Подборки_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переходы.Подборки")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToCollection() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBlockCollectionWithHeader();
        kidsPage.checkElementsBlockCollectionWithoutHeader();
        kidsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        kidsPage.checkBackgroundCardContentForKids();
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
        kidsPage.checkBackgroundCardContentForKids();
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardTvProgram();
        cardTvChannel.checkOpenCardTvChannel();
        headerMenu.goToKidsPage();
        kidsPage.clickToLinkAllOnCollectionBlock();
        collectionsPage.checkOpenCollectionPageForKids();
        collectionsPage.checkElementsPageBlockCollection();
        kidsPage.checkBackgroundPageCollectionForKids();
        headerMenu.goToKidsPage();
        kidsPage.clickToLinkAllWithCollectionFilms();
        collectionsPage.clickToTailFilm();
        cardFilm.checkOpenCardFilm();
        headerMenu.goToKidsPage();
        kidsPage.clickToLinkAllWithCollectionSerial();
        collectionsPage.clickToTailSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToKidsPage();
        kidsPage.clickToLinkAllWithCollectionTvProgram();
        collectionsPage.clickToTailTvProgram();
        cardTvChannel.checkOpenCardTvProgram();
    }
}
