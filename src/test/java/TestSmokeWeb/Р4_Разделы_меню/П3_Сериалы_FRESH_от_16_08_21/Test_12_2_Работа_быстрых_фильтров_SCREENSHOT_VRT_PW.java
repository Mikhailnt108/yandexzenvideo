package TestSmokeWeb.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#1")
public class Test_12_2_Работа_быстрых_фильтров_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "Работа быстрых фильтров (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void quickFilters() throws Exception {
        headerMenuPW.goToSerialsPage();
        serialsPagePW.checkImageBlocksFiltersForGuest();
        serialsPagePW.checkImageScrollQuickFiltersForUnauthorized();
    }
}
