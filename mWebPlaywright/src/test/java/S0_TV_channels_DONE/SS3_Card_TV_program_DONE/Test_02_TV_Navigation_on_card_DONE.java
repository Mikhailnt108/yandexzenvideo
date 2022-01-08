package S0_TV_channels_DONE.SS3_Card_TV_program_DONE;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "AndroidWebPW#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_TV_Navigation_on_card_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "0. TV_channels")
    @Story(value = "1. Section_TV")
    @DisplayName(value = "TV_Navigation_on_card")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#0")
    public void TV_Navigation_on_card() throws InterruptedException {
        headerMenuPW.goToTabTv();
        tvPagePW.openCardTvChannelInRecord();
        cardTvChannelPW.tapOnCurrentTvProgramRecord();
        flowRegistationMF();
        headerMenuPW.goToTabTv();
        tvPagePW.openCardTvChannelInRecord();
        cardTvChannelPW.tapOnCurrentTvProgramRecord();
        cardTvProgramPW.subscribeToPackageTvProgram();
        cardTvProgramPW.openFullDiscription();
        cardTvProgramPW.closeFullDiscription();
        cardTvProgramPW.openFullSchedule();
        cardTvChannelPW.tapOnCurrentTvProgramRecord();
        cardTvProgramPW.tapWatch();
        cardTvProgramPW.checkStartPlayer();
    }
    private void flowRegistationMF() throws InterruptedException {
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginNonAdmWeb("+7 926 020 50 27");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
