package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_9_Пролистывание_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "9. Пролистывание подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void scrollCollectionForChildren() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.scrollСollectionToRight();
        kidsPage.scrollСollectionToLeft();
    }
}
