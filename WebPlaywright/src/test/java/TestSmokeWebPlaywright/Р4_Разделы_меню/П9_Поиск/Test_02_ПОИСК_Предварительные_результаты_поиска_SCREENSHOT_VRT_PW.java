package TestSmokeWebPlaywright.Р4_Разделы_меню.П9_Поиск;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_ПОИСК_Предварительные_результаты_поиска_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "10. Поиск")
    @DisplayName(value ="2. Предварительные результаты поиска (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3")
    public void inputValidRequestInSearch() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToSearchButton();
        headerMenuPW.checkOpenFieldSearch();
        headerMenuPW.inputValidRequestSearch();
        headerMenuPW.checkResponseOnValidSearch();
        headerMenuPW.checkImageResponseOnValidSearch();
    }
}
