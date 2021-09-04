package TestSmokeWeb.Р4_Разделы_меню.П6_Пакеты_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import io.qameta.allure.*;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_Переход_в_пакет_FRESH extends TestBaseWebDriver {
    public VideoRule videoRule = new VideoRule();
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2")
    public void goToPackage() {
        headerMenu.goToPackagesPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


