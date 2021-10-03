import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class TestPw4 extends TestBasePlaywright {
    @Test
    @Tag("SuitePW3")
    void shouldReturnInnerHTML() throws InterruptedException {
        page.setContent("<div>hello</div>");
        assertEquals("hello", page.innerHTML("css=div"));
        Thread.sleep(10000);
    }
}

