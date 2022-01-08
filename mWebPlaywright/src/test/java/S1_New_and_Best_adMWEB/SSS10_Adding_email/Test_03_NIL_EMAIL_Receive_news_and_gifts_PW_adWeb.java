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
public class Test_03_NIL_EMAIL_Receive_news_and_gifts_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. NIL_EMAIL_Receive_news_and_gifts")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_EMAIL_Receive_news_and_gifts() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.checkOpenPageEmail();
        nilPagePW.checkInputValidEmailInProfileMenu("ispolnitel1mt@ya.ru");
        nilPagePW.checkedBoxEmailFormProfile();
        nilPagePW.clickOnButtonSaveAndCheckOpenPopUpLinkedEmail();
        nilPagePW.clickOnButtonCloseAndCheckOpenNilPageAndLinkedEmail();
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 019 21 44");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260192144");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
