import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
//@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_2_TV_Efir_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="Передачи в эфире (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("CheckWithoutRobot")
    public void tvProgramInAir() throws IOException, InterruptedException {
        // неавторизованный пользователь:
        tvPagePW.checkImageTabTvProgramInAirForGuest();
    }
}
