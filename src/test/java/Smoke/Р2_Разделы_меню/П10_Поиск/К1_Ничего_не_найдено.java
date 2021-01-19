package Smoke.Р2_Разделы_меню.П10_Поиск;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Ничего_не_найдено extends TestBase {
    @Test
    public void inputInvalidRequestInSearch(){
        headerMenu.goToNilPage();
        headerMenu.clickToSearchButton();
        headerMenu.checkOpenFieldSearch();
        headerMenu.inputInvalidRequestSearch();
        headerMenu.checkResponseOnInvalidSearch();
    }

}
