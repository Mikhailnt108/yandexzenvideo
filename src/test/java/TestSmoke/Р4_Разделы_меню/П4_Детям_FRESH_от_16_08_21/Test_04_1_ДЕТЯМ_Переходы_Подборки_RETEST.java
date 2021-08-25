package TestSmoke.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_04_1_ДЕТЯМ_Переходы_Подборки_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="4.1 Переходы.Подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
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
