package TestSmoke.Р4_Разделы_меню.П6_Спорт;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_Работа_фильтров_ДОБАВИТЬ_ASHOT_АКТУАЛЕН_24_02_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value ="Работа фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "76")
    public void filterOperation() throws InterruptedException {
        headerMenu.goToSportPage();
        sportPage.chooseFilterSportAndCheckTvChannels();
        sportPage.chooseFilterSportAndCheckTvProgram();


    }
}
