import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@Execution(ExecutionMode.SAME_THREAD)
//@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class TestPw3 extends TestBasePlaywright {
        @Test
        @Tag("SuitePW2")
        void shouldSearchWiki() throws InterruptedException {
            page.navigate("https://www.wikipedia.org/");
            page.click("input[name=\"search\"]");
            page.fill("input[name=\"search\"]", "playwright");
            page.press("input[name=\"search\"]", "Enter");
            System.out.println(page.url());
            Thread.sleep(10000);
            assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());

        }
    }

