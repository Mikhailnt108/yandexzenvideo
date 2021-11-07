package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS5_Search;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_NIL_BASIC_There_is_no_picture_on_tile_BEGIN_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "4. There_is_no_picture_on_tile_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void MessageSelectingContentForYou() throws IOException, InterruptedException {
        headerMenuPW.deleteImagesFromFilm();
    }
}
