package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_7_Переход_в_пакет_из_карточки_сериала extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Переход в пакет из карточки сериала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void GoToPackageFromSeriesCard() {
        headerMenu.goToSerialsPage();
        serialsPage.clickToTailCardSerial();
        cardSerial.clickNamePackage();
        cardPackage.checkOpenCardPackageSerials();
    }
 }
