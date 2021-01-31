package TestSmoke.Р2_Разделы_меню.П7_Пакеты;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class К1_Переход_в_пакет extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToPackage() {
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


