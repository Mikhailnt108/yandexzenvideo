package TestSmoke.Р2_Разделы_меню.П7_Пакеты;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К1_Переход_в_пакет extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToPackage() {
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


