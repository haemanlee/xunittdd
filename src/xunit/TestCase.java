package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    // template method 패턴으로 만들어짐
    public void run() {
        setUp();

        // 리플랙션으로 이름으로 매소드 불러올 수 있음
        try {
            Method method = getClass().getMethod(name);
            // 찾은 메소드를 실행
            method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        
        tearDown();
    }

    public void setUp() {
    }
    public void tearDown() {
    }
}
