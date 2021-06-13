package TestSmoke.Р4_Разделы_меню.П7_Пакеты;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Переход_в_пакет_FRESH_от_04_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "7. Пакеты")
    @DisplayName(value ="Переход в пакет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "7")
    public void goToPackage() {
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


