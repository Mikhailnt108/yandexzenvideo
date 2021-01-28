package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_1_Пролистывание_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Пролистывание подборки")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void scrollCollection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.scrollСollectionToRight();
        nilPage.scrollСollectionToLeft();
    }

}
