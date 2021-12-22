package S0_TV_channels.SS1_Section_TV_DONE;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;

@ResourceLock(value = "AndroidWebPW#1Test", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_TV_Genres_filter_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "0. TV_channels")
    @Story(value = "1. Section_TV")
    @DisplayName(value = "TV_Genres_filter")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#1Test")
    public void TV_Genres_filter() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        headerMenuPW.goToTabTv();
        tvPagePW.scrollTabsFiltersTvGenres();
        tvPagePW.chooseTabFiltersTvGenres();
    }
}