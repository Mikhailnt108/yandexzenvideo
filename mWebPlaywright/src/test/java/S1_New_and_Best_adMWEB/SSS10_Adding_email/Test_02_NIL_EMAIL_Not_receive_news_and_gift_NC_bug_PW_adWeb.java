package S1_New_and_Best_adMWEB.SSS10_Adding_email;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_EMAIL_Not_receive_news_and_gift_NC_bug_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. NIL_EMAIL_Not_receive_news_and_gift")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_EMAIL_Not_receive_news_and_gift() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.checkOpenPageEmail();
        nilPagePW.checkInputInvalidEmailInProfileMenu("mail.ru");
        nilPagePW.unCheckedBoxEmailFormProfile();
        nilPagePW.checkInputValidEmailInProfileMenu("ispolnitel1mt@ya.ru");
        nilPagePW.clickOnButtonSaveAndCheckOpenPopUpNoNewsAndGifts();
        nilPagePW.checkImagePopUpNoNewsAndGifts();
        nilPagePW.clickOnButtonCancelAndCheckOpenEmail();
        nilPagePW.clickOnButtonSaveAndCheckOpenPopUpNoNewsAndGifts();
        nilPagePW.clickOnButtonYesAndCheckOpenPopUpLinkedEmail();
        nilPagePW.checkImagePopUpLinkedEmail();
        nilPagePW.clickOnButtonCloseAndCheckOpenNilPageAndLinkedEmail();
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdmWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdWeb("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}