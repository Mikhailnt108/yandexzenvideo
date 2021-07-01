package TestSmoke.Р4_Разделы_меню.П7_Пакеты;

import base.TestBase;
import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Переход_в_пакет_FRESH_от_04_06_21 extends TestBase {

    @Rule
    public VideoRule videoRule = new VideoRule();
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Video


    public void goToPackage() {


        headerMenu.goToPackagesPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


