package TestSmoke.старые_кейсы.разделы_меню.тв;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OldTest_16_Переход_в_пакет_из_карточки_передачи extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Переход в пакет из карточки передачи")
    @Severity(SeverityLevel.BLOCKER)
    @Test
     public void goToPackageFromCardTvProgram() throws InterruptedException {
         headerMenu.goToTvPage();
         flowRegistation();
         tvPage.checkOpenTvPageTabScheduleTv();
         tvPage.clickOnTabTvProgramInAir();
         tvPage.clickToTailTvProgram();
         cardTvProgram.checkOpenCardTvProgram();
         cardTvProgram.clickToLinkCardPackage();
         cardPackage.checkOpenCardPackageTvChannel();
         pageCMS.deleteAccountMF("79260192144");
     }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }

}
