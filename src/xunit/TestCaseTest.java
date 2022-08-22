package xunit;

import xunit.annotation.Test;

public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

    public static TestSuite suite() {
        return new TestSuite(TestCaseTest.class);
//        TestSuite testSuite = new TestSuite();
//        testSuite.add(new TestCaseTest("testTemplateMethod"));
//        testSuite.add(new TestCaseTest("testResult"));
//        testSuite.add(new TestCaseTest("testFailedResultFormatting"));
//        testSuite.add(new TestCaseTest("testFailedResult"));
//        testSuite.add(new TestCaseTest("testSuite"));
//        return testSuite;
    }

    @Test
    public void testTemplateMethod() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    @Test
    public void testResult() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    @Test
    public void testFailedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testSuite(){
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        TestResult result = new TestResult();
        suite.run(result);
        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }
}
