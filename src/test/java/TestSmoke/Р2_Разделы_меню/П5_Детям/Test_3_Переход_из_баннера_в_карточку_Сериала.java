package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_3_Переход_из_баннера_в_карточку_Сериала extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Переход из баннера в карточку Сериала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void SwitchingFromBannerToCardSerial() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardSerial();
    }

}
