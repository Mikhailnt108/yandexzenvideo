package S1_New_and_Best_adMWEB.SS3_Collections.SS2_Tails_сontents;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_NIL_TILES_Tv_channels_in_collection_PW_bug_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "4. NIL_TILES_Tv_channels_in_collection")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#2")
    public void NIL_TILES_Tv_channels_in_collection() throws IOException, InterruptedException {
        // Guest
        headerMenuPW.goToNilPage();
        nilPagePW.checkLastTilePackageTvChannel();
        nilPagePW.checkImageHoverTileTVChannelCollectionGustMWEB();
        // User
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.checkLastTilePackageTvChannel();
        nilPagePW.checkImageHoverTileTVChannelCollectionUserMWEB();
    }
    private void flowRegistation() {
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
    }
}
