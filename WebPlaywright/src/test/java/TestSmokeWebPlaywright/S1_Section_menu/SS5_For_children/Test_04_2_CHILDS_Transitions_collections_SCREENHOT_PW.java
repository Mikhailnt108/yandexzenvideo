package TestSmokeWebPlaywright.S1_Section_menu.SS5_For_children;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_2_CHILDS_Transitions_collections_SCREENHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "5. For_children")
    @DisplayName(value ="04_2_CHILDS_Transitions_collections_SCREENHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void CHILDS_Transitions_collections_SCREENHOT() throws Exception {
        headerMenuPW.goToKidsPage();
        kidsPagePW.clickToLinkAllOnCollectionBlock();
//        collectionPagePW.checkBackgroundPageCollectionForKids();
        collectionPagePW.checkImagePageCollectionForKids();
    }
}
