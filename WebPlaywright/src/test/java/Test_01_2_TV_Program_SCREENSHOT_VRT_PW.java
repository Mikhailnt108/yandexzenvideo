import base.TestBasePlaywright;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//@Execution(ExecutionMode.SAME_THREAD)
//@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_TV_Program_SCREENSHOT_VRT_PW extends TestBasePlaywright {
//    @Epic(value = "Smoke MFTV Desktop Web")
//    @Feature(value = "0. Разделы меню")
//    @Story(value = "1. ТВ")
//    @DisplayName(value = "Программа передач (скриншоты)")
//    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwTest1")
    public void historyViewing() throws Exception {
        tvPagePW.checkImageTvPageTabProgramTvForGuest();
    }
}
