package base;

import com.github.rsheremeta.testrail.TestRailCreds;
import com.github.rsheremeta.testrail.TestRailHelper;
import com.github.rsheremeta.testrail.TestResult;
import org.junit.jupiter.api.extension.*;
import java.util.Optional;


public class TestRailListener implements BeforeAllCallback, TestWatcher {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        String ProjectID = "1";
        String testRunName = "AutoSmoke TestRail Run - ";
        TestRailCreds creds = new TestRailCreds.Builder()
                .withProjectUrl("https://mikhailnt.testrail.io/")
                .withUsername("mikhailnt@bk.ru")
                .withPassword("Tequilajazzz87")
                .build();
        TestRailHelper.createNewTestRailRun(creds, ProjectID, testRunName);
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> reason) {
// This is empty as TestRail does not allow to add result as “Untested”, which is a default value already for every test in a run
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        TestRailHelper.setTestRailStatus(extensionContext, TestResult.PASSED);
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable cause) {
        TestRailHelper.setTestRailStatus(extensionContext, TestResult.BLOCKED);
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {
        TestRailHelper.setTestRailStatus(extensionContext, TestResult.FAILED);
    }
}