package TestSmoke.Р4_Разделы_меню.П7_Пакеты;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestClassTwo extends TestBase {


//    @Test
//    @TestRailCase(id = "3")
    @DisplayName("This Test should be passed")
    public void twoFirst() {
        Assert.assertTrue(true);
        System.out.println("Passed");
    }

//    @Test
//    @TestRailCase(id = "4")
    @DisplayName("This Test should be failed")
    public void twoSecond() {
        int a = 3;
        int b = a/0;
        Assert.assertEquals(a, b); // division by zero
        System.out.println("Failed with exception");
    }

}