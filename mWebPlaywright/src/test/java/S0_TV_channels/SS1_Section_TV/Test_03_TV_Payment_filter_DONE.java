package S0_TV_channels.SS1_Section_TV;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "AndroidWebPW#1Test", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_TV_Payment_filter_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "0. TV_channels")
    @Story(value = "1. Section_TV")
    @DisplayName(value = "TV_Payment_filter")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#1Test")
    public void TV_Payment_filter() throws InterruptedException {
        headerMenuPW.goToTabTv();
        flowRegistationMF();
        headerMenuPW.goToTabTv();
        tvPagePW.clickOnPaymentFilter();
        tvPagePW.chooseFilterAvailableTvChannels();
        tvPagePW.chooseFilterAllTvChannels();
    }
    private void flowRegistationMF() throws InterruptedException {
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginNonAdmWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
