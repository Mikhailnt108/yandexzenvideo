package TestSmoke.Р4_Разделы_меню.П8_Подборки;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_01_Внешний_вид_страницы_Подборки_SCREENSHOT_VRT_Playwright extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="Внешний вид страницы (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceOfPageCollection() throws IOException, InterruptedException {
        headerMenuPW.goToAllCollectionsPage();
        allCollectionsPagePW.checkElementsPageAllCollections();
        allCollectionsPagePW.checkImagePageAllCollections();
    }
}
