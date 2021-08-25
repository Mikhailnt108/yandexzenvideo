package TestSmoke.Р4_Разделы_меню.П7_Подборки;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock("Suite#2")
public class Test_01_Внешний_вид_страницы_Подборки_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="1. Внешний вид страницы (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceOfPageCollection() throws IOException, InterruptedException {
        headerMenuPW.goToAllCollectionsPage();
        allCollectionsPagePW.checkElementsPageAllCollections();
        allCollectionsPagePW.checkImagePageAllCollections();
    }
}
