package TestSmoke.Р3_Разделы_меню.П8_Подборки;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_01_Внешний_вид_страницы_Подборки_ASHOT_FRESH_от_07_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="Внешний вид страницы")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceOfPageCollection() throws IOException {
        headerMenu.goToAllCollectionsPage();
        allCollectionsPage.checkElementsPageCollections();
        allCollectionsPage.checkImageDifferPageCollections();
    }
}
