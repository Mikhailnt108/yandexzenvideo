package TestSmokeWebDriver.S1_Sections_menu.SS6_Collections;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_1_COLLECTIONS_Actions_with_collections extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "8. Collections")
    @DisplayName(value ="Actions_with_collections")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31547362")
    @Test
    @Tag("SuiteWD#3")
    public void actionsWithCollections() throws InterruptedException {
        headerMenu.goToAllCollectionsPage();
        allCollectionsPage.clickToTailCollection();
        collectionsPage.clickToTailContentOnPageCollect();
        allCollectionsPage.selectCollectionForKids();
        kidsPage.checkBackgroundPageCollectionForKids();
        collectionsPage.clickToTailContentOnPageCollect();
        kidsPage.checkBackgroundCardContentForKids();
    }
}
