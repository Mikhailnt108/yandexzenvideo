package TestSmoke.Р3_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_09_Пролистывание_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Пролистывание подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void scrollCollectionForChildren() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.scrollСollectionToRight();
        kidsPage.scrollСollectionToLeft();
    }
}
