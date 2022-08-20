package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase implements Test{
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    // template method 패턴으로 만들어짐
    public void run(TestResult testResult) {
        setUp();

        testResult.testStarted();
        // 리플랙션으로 이름으로 매소드 불러올 수 있음
        try {
            Method method = getClass().getMethod(name);
            // 찾은 메소드를 실행
            method.invoke(this);
        } catch (Exception e) {
            testResult.testFailed();
        }
        
        tearDown();
    }

    public void setUp() {
    }
    public void tearDown() {
    }
}
