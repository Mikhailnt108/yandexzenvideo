import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@Execution(ExecutionMode.SAME_THREAD)
//@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class TestPw2 extends TestBasePlaywright {
        @Test
        @Tag("SuitePW1")
        void shouldCheckTheBox() throws InterruptedException {
            page.setContent("<input id='checkbox' type='checkbox'></input>");
            page.check("input");
            assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
            Thread.sleep(10000);
        }
}

