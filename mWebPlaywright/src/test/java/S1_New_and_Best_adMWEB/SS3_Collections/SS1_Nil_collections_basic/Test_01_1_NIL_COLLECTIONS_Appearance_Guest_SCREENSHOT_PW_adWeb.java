package S1_New_and_Best_adMWEB.SS3_Collections.SS1_Nil_collections_basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_1_NIL_COLLECTIONS_Appearance_Guest_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1. NIL_COLLECTIONS_Appearance_Guest_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_COLLECTIONS_Appearance_Guest() throws IOException, InterruptedException {
        // Guest:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsCollection();
        nilPagePW.checkImageBlocksCollectionAphonePageNilGuest();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsCollection();
        nilPagePW.checkImageBlocksCollectionApadPageNilGuest();
        // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.checkElementsCollection();
//        nilPagePW.checkImageBlocksCollectionWidePageNilGuestMWEB();
    }
}
