package Smoke.Р2_Разделы_меню.П4_Сериалы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К7_Переход_в_пакет_из_карточки_сериала extends TestBase {
    @Test
    public void GoToPackageFromSeriesCard() {
        headerMenu.goToSerialsPage();
        serialsPage.clickToTailCardSerial();
        cardSerial.clickNamePackage();
        cardPackage.checkOpenCardPackageSerials();
    }
 }
