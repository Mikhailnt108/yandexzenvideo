package TestSmokeWeb.Р4_Разделы_меню.П7_Подборки;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock("Suite#2")
public class Test_02_2_Действия_с_подборками_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="2.2 Действия с подборками (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void actionsWithCollections() throws IOException, InterruptedException {
        headerMenuPW.goToAllCollectionsPage();
        allCollectionsPagePW.clickToTailCollection();
        collectionPagePW.checkImagePageCollection();
    }
}
