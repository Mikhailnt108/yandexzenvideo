package TestSmokeWebDriver.S1_Sections_menu.SS4_For_children;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_1_ДЕТЯМ_Переходы_Подборки_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="4.1 Переходы.Подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#2")
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
