package TestSmoke.Р4_Разделы_меню.П5_Детям;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_04_2_Переходы_Подборки_SCREENSHOT_VRT_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переходы.Подборки (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToCollection() throws Exception {
        headerMenuPW.goToKidsPage();
        kidsPagePW.clickToLinkAllOnCollectionBlock();
//        collectionPagePW.checkBackgroundPageCollectionForKids();
        collectionPagePW.checkImagePageCollectionForKids();
    }
}
