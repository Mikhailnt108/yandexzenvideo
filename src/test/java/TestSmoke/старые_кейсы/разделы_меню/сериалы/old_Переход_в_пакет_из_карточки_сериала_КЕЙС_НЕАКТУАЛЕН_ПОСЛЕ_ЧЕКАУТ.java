package TestSmoke.старые_кейсы.разделы_меню.сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_Переход_в_пакет_из_карточки_сериала_КЕЙС_НЕАКТУАЛЕН_ПОСЛЕ_ЧЕКАУТ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Переход в пакет из карточки сериала")
    @Severity(SeverityLevel.BLOCKER)
    @Test

    public void GoToPackageFromSeriesCard() {
        headerMenu.goToSerialsPage();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.clickNamePackage();
        cardPackage.checkOpenCardPackageSerials();
    }
 }
