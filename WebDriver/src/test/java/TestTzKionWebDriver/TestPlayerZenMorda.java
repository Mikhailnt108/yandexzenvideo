package TestTzKionWebDriver;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

public class TestPlayerZenMorda extends TestBaseWebDriver {
    @Epic(value = "TzKion")
    @Feature(value = "1. ZenMorda")
    @Story(value = "1. PlayerZenMorda")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @Tag("TzKion")
    public void actionPlayerZenMorda() throws InterruptedException {
        yandexPageMain.openYandexPageMain();
        yandexPageMain.goToZenPageFeed();
        zenPageFeed.checkElementsZenPageFeed();
        zenPageFeed.goToZenPageVideo();
        zenPageVideo.checkElementsZenPageVideo();
        zenPageVideo.inputRequest("Синий трактор");
        zenPageSearch.openPlayer();
        zenPlayer.checkStartPlayVideo();
        zenPlayer.checkControlsPlayer();
        zenPlayer.checkFullScreenPlayer();
    }
}
