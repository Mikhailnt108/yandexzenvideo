package TestSmokeWebPlaywright.S1_Section_menu.SS1_TV;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Example3", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_2_TV_Card_tv_channel_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value = "TV_Card_tv_channel_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("36965360")
    @Test
    @Tag("Example3")
    public void tv_Card_tv_channel_SCREENSHOT() throws IOException, InterruptedException, SQLException {
        // неавторизованный пользователь:
        cardTvChannelPW.checkImageCardTvChannelForGuest();
        // авторизованный пользователь:
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        cardTvChannelPW.checkImageCardTvChannelForUser();
        headerMenuPW.deleteAccountMF("79260205027");
    }
    private void flowRegistationMF() throws SQLException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.inputCodeMsisdnFromDB("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
