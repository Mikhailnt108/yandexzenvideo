package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_Внешний_вид_раздела_SCREENSHOT_VRT_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Внешний вид раздела (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionNilPage() throws IOException, InterruptedException{
        niLPagePW.checkImageCherdakAndBanners();
        niLPagePW.checkImageBlocksCollectionWithHeader();
        niLPagePW.checkImageBlocksCollectionWithoutHeader();
        niLPagePW.checkImageFooter();
        niLPagePW.checkImageNilPageScroll();
    }
}
