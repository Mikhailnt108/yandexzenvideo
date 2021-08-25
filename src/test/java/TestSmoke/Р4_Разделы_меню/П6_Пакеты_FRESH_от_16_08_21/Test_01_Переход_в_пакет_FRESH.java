package TestSmoke.Р4_Разделы_меню.П6_Пакеты_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import io.qameta.allure.*;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_01_Переход_в_пакет_FRESH extends TestBaseWebDriver {

    @Rule
    public VideoRule videoRule = new VideoRule();
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToPackage() {
        headerMenu.goToPackagesPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


