import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class TestPw5 extends TestBasePlaywright {
    @Test
    @Tag("SuitePW4")
    void shouldClickButton() throws InterruptedException {
        Page popup = page.waitForPopup(() -> {
            page.evaluate("window.open('about:blank');");
        });
        assertEquals("about:blank", popup.url());
        Thread.sleep(10000);
    }
}

