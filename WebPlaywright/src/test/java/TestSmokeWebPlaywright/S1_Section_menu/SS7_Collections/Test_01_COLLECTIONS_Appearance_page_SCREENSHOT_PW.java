package TestSmokeWebPlaywright.S1_Section_menu.SS7_Collections;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "SuitePW#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_COLLECTIONS_Appearance_page_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "8. Collections")
    @DisplayName(value ="01_COLLECTIONS_Appearance_page_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePW#4")
    public void COLLECTIONS_Appearance_page_SCREENSHOT() throws IOException, InterruptedException {
        headerMenuPW.goToAllCollectionsPage();
        allCollectionsPagePW.checkElementsPageAllCollections();
        allCollectionsPagePW.checkImagePageAllCollections();
    }
}
