package TestSmokeWebPlaywright.S4_Section_menu.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_2_СЕРИАЛЫ_Внешний_вид_карточки_SCREENSHOT_PLAYER_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "3.2 Внешний вид карточки (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#4")
    public void appearanceSectionCardSerial() throws Exception {
        headerMenuPW.goToSerialsPage();
        serialsPagePW.clickToTailCardSerial();
        cardSerialPW.checkStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForGuest();
        flowRegistationMF();
        cardSerialPW.subscribeToPackageSerials();
        cardSerialPW.checkStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForUser();
        headerMenuPW.deleteAccountMF("79250110166");
    }

    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
