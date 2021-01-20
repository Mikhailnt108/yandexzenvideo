package TestSmoke.Р2_Разделы_меню.П7_Пакеты;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Переход_в_пакет extends TestBase {
    @Test
    public void goToPackage() {
        headerMenu.goToPackagesPage();
        packagesPage.clickToTailCardPackage();
        cardPackage.checkOpenCardPackage();
        }
    }


