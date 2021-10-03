import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;

import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

// Subclasses will inherit PER_CLASS behavior.
@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBasePlaywright {
// Shared between all tests in the class.
        Playwright playwright;
        Browser browser;

        @BeforeAll
        void launchBrowser() {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true).setArgs(Arrays.asList("--disable-dev-shm-usage")));
        }

        @AfterAll
        void closeBrowser() {
            playwright.close();
        }
        // New instance for each test method.
        BrowserContext context;
        Page page;

        @BeforeEach
        void createContextAndPage() {
            context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(1900, 920));
            page = context.newPage();
        }

        @AfterEach
        void closeContext() {
            context.close();
        }
    }

