package TestSmokeWebDriver.S1_Sections_menu.SS4_For_childs;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_1_CHILDS_Transitions_collection extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "5. Childs")
    @DisplayName(value ="Transitions_collection")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("39192988")
    @Test
    @Tag("SuiteWD#2")
    public void goToCollection() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBlockCollectionWithHeader();
        kidsPage.checkElementsBlockCollectionWithoutHeader();
        kidsPage.clickToSecondTailCardFilm();
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
