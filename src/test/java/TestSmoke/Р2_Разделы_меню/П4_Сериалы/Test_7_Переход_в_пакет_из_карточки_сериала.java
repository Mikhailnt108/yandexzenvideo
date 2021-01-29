package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_7_Переход_в_пакет_из_карточки_сериала extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "7. Переход в пакет из карточки cериала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void GoToPackageFromSeriesCard() {
        headerMenu.goToSerialsPage();
        serialsPage.clickToTailCardSerial();
        cardSerial.clickNamePackage();
        cardPackage.checkOpenCardPackageSerials();
    }
 }
