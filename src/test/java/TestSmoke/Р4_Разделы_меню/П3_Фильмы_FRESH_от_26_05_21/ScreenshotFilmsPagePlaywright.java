package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBasePlaywright;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class ScreenshotFilmsPagePlaywright extends TestBasePlaywright {
    @Test
    public void screenshotFilmsPage() throws IOException, InterruptedException {
        filmsPagePW.screenshotFilmsPagePW();
        filmsPagePW.screenshotsFilmsPagePwUsingVRT();
    }
}
