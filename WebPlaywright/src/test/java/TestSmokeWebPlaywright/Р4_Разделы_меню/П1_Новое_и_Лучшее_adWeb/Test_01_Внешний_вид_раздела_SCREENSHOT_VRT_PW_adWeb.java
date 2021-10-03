package TestSmokeWebPlaywright.Р4_Разделы_меню.П1_Новое_и_Лучшее_adWeb;

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

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_Внешний_вид_раздела_SCREENSHOT_VRT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "1. Внешний вид раздела (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void appearanceSectionNilPage() throws IOException, InterruptedException{
        niLPagePW.checkImageNilPageScroll();
        niLPagePW.checkImageCherdakAndBanners();
        niLPagePW.checkImageBlocksCollectionWithHeader();
        niLPagePW.checkImageBlocksCollectionWithoutHeader();
        niLPagePW.checkImageFooter();
    }
}
