package TestSmoke.старые_кейсы.разделы_меню.новое_и_лучшее;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OldTest_01_Пролистывание_подборки_ДОБАВИТЬ_ASHOT extends TestBaseWebDriver {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Пролистывание подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void scrollCollection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.scrollСollectionToRight();
        nilPage.scrollСollectionToLeft();
    }
}
