package xunit;

public class TestResult {
    int runCount = 0;
    int errCount;

    public void testStarted(){
        runCount++;
    }
    public String getSummary() {
        return runCount + " run, "+ errCount +" failed";
    }

    public void testFailed() {
        errCount++;
    }
}
