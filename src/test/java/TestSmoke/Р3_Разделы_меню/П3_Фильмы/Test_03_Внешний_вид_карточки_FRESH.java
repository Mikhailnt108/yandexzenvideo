package TestSmoke.Р3_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_03_Внешний_вид_карточки_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Внешний вид карточки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionCardFilm() throws IOException, InterruptedException {
        // неавторизованный пользователь:
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkImageDifferCardFilm();

//        headerMenu.goToTvPage();
//        tvPage.checkOpenTvPageTabScheduleTv();
//        tvPage.clickOnTabInRecording();
//        tvPage.clickToTailTvChannel();
//        cardTvChannel.checkOpenCardTvChannel();
//        cardTvChannel.checkImageDifferCardTvChannelForUnauthorized();
//        cardTvChannel.checkElementsInCardTvChannel();
//        // авторизованный пользователь:
//        headerMenu.goToTvPage();
//        flowRegistation();
//        tvPage.clickOnTabInRecording();
//        tvPage.clickToTailTvChannel();
//        cardTvChannel.checkOpenCardTvChannel();
//        cardTvChannel.clickPaymentButtonInCardTvChannel();
//        cardTvChannel.checkPaymentComplete();
//        headerMenu.refreshPage();
//        cardTvChannel.checkAutoStartVideoPlayer();
//        cardTvChannel.checkButtonFavoriteNotAdded();
//        cardTvChannel.clickOnButtonFavorite();
//        cardTvChannel.checkButtonFavoriteAdded();
//        cardTvChannel.clickOnTvProgramInCardChannel();
//        cardTvProgram.checkOpenCardTvProgram();
//        pageCMS.deleteAccountMF("79260192144");

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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}

