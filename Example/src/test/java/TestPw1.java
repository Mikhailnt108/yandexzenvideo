import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.assertEquals;
//@Execution(ExecutionMode.SAME_THREAD)
//@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class TestPw1 extends TestBasePlaywright {
        @Test
        @Tag("SuitePwTest1")
        void shouldClickButton() {
            page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
            page.click("button");
            assertEquals("Clicked", page.evaluate("result"));
        }
    }

