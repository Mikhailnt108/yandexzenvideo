package base;

import io.github.legionivo.api.testrail.TestRail;
import io.github.legionivo.api.testrail.model.*;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TestRailReportExtension implements TestWatcher, BeforeAllCallback {

    private static boolean started = false;
    private static final String TESTRAIL_REPORT = "TEST_RAIL";
    private static List<Result> results = new CopyOnWriteArrayList<>();

    @Override
    public void testSuccessful(ExtensionContext context) {
        addResult(context, TestRailStatus.PASSED);
    }
    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        addResult(extensionContext, TestRailStatus.DISABLED);
    }
    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable cause) {
        addResult(extensionContext, TestRailStatus.BLOCKED);
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {
        addResult(extensionContext, TestRailStatus.FAILED);
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {

        if (!started) {
            getStore(extensionContext).put(TESTRAIL_REPORT, new CloseableOnlyOnceResource());
            started = true;
        }
    }

    private static class CloseableOnlyOnceResource implements
            ExtensionContext.Store.CloseableResource {
        @Override
        public void close() {
            //After all tests run hook.
            //Any additional desired action goes here
            reportResults();
        }
    }

    private void addResult(ExtensionContext extensionContext, TestRailStatus status) {
        //TmsLink is an annotation from Allure framework
        if (extensionContext.getElement().isPresent() && extensionContext.getElement().get().isAnnotationPresent(
                TmsLink.class)) {
            TmsLink element = extensionContext.getElement().get().getAnnotation(TmsLink.class);
            String exceptionMessage = extensionContext.getExecutionException().map(Throwable::getMessage).orElse(null);
            Result result = new Result().setComment(exceptionMessage).setTestId(Integer.parseInt(element.value())).setStatusId(status.getId())
                    .setCaseId(Integer.valueOf(element.value()));
            addResult(result);
        }
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL);
    }

    private static void addResult(Result result) {
        results.add(result);
    }

    private static void reportResults() {
//        if (testRailEnabled()) { // replace with your own method of reading data from prom properties file
        final String url = "https://testrail.megalabs.ru";
        final String userId = "mtabunkov";
        final String pwd = "14111987m=-=";
        final Integer projectId = 1;
        final Integer testSuiteId = 1; // Suite ID should be unique per project
//            final Integer planId = 1111; // Test plan reflects current version which is tested
        final Integer milestone = 138; // Milestone is set per each project and should reflect release version(e.g. 1.0, 666)
        final String browserName = "Google Chrome";
        final String description = "Automatically generated test suite";
        final String name = "[AutoSmoke][Web][WD] Test Run on browser Google Chrome last version, completed - ";
        TestRail testRail = TestRail.builder(url, userId, pwd).build();
        String currentDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));
        Project project = testRail.projects().get(projectId).execute();
        Run run = testRail.runs()
                .add(project.getId(),
                        new Run().setName(name + currentDateTime)
                                .setDescription(description)
                                .setIncludeAll(false)
                                .setSuiteId(testSuiteId)
                                .setMilestoneId(milestone)
//                                    .setPlanId(planId)
                                .setCaseIds(results.stream()
                                        .map(Result::getCaseId).collect(Collectors.toCollection(CopyOnWriteArrayList::new)))
                ).execute();
        List<ResultField> customResultFields = testRail.resultFields().list().execute();
        List<CaseField> caseFields = testRail.caseFields().list().execute();
        List<Result> finalResults;
        finalResults = results;
        for (Result result : results) {
            try {
                testRail.cases().get(result.getCaseId(), caseFields).execute();
            } catch (Exception e) {
                finalResults.remove(result);
                System.out.println("Test Case with ID " + result.getCaseId() + " does not exist in TestRail! \n");
            }
        }
        testRail.results().addForCases(run.getId(), finalResults, customResultFields).execute();
        testRail.runs().close(run.getId()).execute();
//        } else System.out.println("TestRail reporting is disabled... Skipping");
    }

    private enum TestRailStatus {
        PASSED(1),
        BLOCKED(2),
        UNTESTED(3),
        FAILED(4),
        DISABLED(5); //This is a custom test status added manually!

        private int id;

        public int getId() {
            return id;
        }

        TestRailStatus(int id) {
            this.id = id;
        }
    }
}

