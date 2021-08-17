package TestSmoke.Р4_Разделы_меню.П5_Детям_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_04_2_Переходы_Подборки_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="4.2 Переходы.Подборки (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollection() throws Exception {
        headerMenuPW.goToKidsPage();
        kidsPagePW.clickToLinkAllOnCollectionBlock();
//        collectionPagePW.checkBackgroundPageCollectionForKids();
        collectionPagePW.checkImagePageCollectionForKids();
    }
}
