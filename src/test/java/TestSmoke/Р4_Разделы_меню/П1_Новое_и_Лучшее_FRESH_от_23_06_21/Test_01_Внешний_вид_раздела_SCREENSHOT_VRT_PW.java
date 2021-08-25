package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock("Suite#1")
public class Test_01_Внешний_вид_раздела_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "1. Внешний вид раздела (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionNilPage() throws IOException, InterruptedException{
        niLPagePW.checkImageNilPageScroll();
        niLPagePW.checkImageCherdakAndBanners();
        niLPagePW.checkImageBlocksCollectionWithHeader();
        niLPagePW.checkImageBlocksCollectionWithoutHeader();
        niLPagePW.checkImageFooter();
    }
}
