package TestSmokeWeb.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_2_Переходы_Баннеры_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переходы.Баннеры (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
    @Tag("Suite#2")
    public void goToBanner() throws Exception {
        kidsPagePW.checkImageCherdakAndBannersForGuest();
    }
}
