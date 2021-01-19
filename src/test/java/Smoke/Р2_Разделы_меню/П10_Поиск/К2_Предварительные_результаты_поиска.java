package Smoke.Р2_Разделы_меню.П10_Поиск;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Предварительные_результаты_поиска extends TestBase {
    @Test
    public void inputInvalidRequestInSearch(){
        headerMenu.goToNilPage();
        headerMenu.clickToSearchButton();
        headerMenu.checkOpenFieldSearch();
        headerMenu.inputValidRequestSearch();
        headerMenu.checkResponseOnValidSearch();
    }
}
