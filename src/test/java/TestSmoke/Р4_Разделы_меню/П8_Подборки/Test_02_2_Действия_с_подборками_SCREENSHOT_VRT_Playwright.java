package TestSmoke.Р4_Разделы_меню.П8_Подборки;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import java.io.IOException;

public class Test_02_2_Действия_с_подборками_SCREENSHOT_VRT_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="Действия с подборками (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void actionsWithCollections() throws IOException, InterruptedException {
        headerMenuPW.goToAllCollectionsPage();
        allCollectionsPagePW.clickToTailCollection();
        collectionPagePW.checkImagePageCollection();
    }
}
