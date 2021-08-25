package TestSmoke.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_01_Внешний_вид_раздела_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Внешний вид раздела (скринщоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
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
