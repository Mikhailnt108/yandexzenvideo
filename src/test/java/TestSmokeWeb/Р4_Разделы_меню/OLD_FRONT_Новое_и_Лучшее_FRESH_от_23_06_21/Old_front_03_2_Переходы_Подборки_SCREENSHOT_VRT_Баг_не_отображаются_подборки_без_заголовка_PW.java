package TestSmokeWeb.Р4_Разделы_меню.OLD_FRONT_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Old_front_03_2_Переходы_Подборки_SCREENSHOT_VRT_Баг_не_отображаются_подборки_без_заголовка_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Подборки (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void goToCollection() throws Exception {
        niLPagePW.checkImageBlocksCollectionWithHeader();
        niLPagePW.checkImageBlocksCollectionWithoutHeader();
    }
}
