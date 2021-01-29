package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_6_Переход_из_баннера_в_карточку_Смешанного_Пакета extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "6. Переход из баннера в карточку Смешанного Пакета")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void SwitchingFromBannerToCardPackage() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardPackage();
    }
}
