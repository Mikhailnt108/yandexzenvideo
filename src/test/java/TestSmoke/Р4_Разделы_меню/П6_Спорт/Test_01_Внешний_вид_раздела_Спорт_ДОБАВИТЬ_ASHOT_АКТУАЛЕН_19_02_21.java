package TestSmoke.Р4_Разделы_меню.П6_Спорт;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Внешний_вид_раздела_Спорт_ДОБАВИТЬ_ASHOT_АКТУАЛЕН_19_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value = "Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test

    public void visualDesignPageSport() throws InterruptedException {
        headerMenu.goToSportPage();
        sportPage.checkElementsOnPageSport();
        sportPage.scrollCollectionSportChannelsToRight();
        sportPage.scrollCollectionSportChannelsToLeft();
    }
}
