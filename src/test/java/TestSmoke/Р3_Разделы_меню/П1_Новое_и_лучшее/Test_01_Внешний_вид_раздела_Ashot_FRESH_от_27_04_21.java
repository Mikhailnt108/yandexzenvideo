package TestSmoke.Р3_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Внешний_вид_раздела_Ashot_FRESH_от_27_04_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void navigatingSection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkImageDifferHeader();
        nilPage.checkImageDifferBlockCollection();
        nilPage.checkImageDifferNilPageAll();
    }
}
