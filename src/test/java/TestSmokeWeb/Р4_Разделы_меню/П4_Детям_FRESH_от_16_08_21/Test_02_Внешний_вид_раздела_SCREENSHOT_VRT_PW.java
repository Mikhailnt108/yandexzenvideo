package TestSmokeWeb.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_Внешний_вид_раздела_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Внешний вид раздела (скринщоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2Exp")
    public void appearanceSectioтKidsPage() throws Exception {
        // пользователь НЕ авторизован:
        kidsPagePW.checkImageKidsPageScrollForGuest();
        kidsPagePW.checkImageCherdakAndBannersForGuest();
        kidsPagePW.checkImageBlocksCollectionWithHeaderFofGuest();
        kidsPagePW.checkImageBlocksCollectionWithoutHeaderForGuest();
        kidsPagePW.checkImageFooterForGuest();
//        kidsPagePW.checkBackgroundKidsPage();
    }
}
