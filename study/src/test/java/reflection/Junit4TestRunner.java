package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;

        // TODO Junit4Test에서 @MyTest 애노테이션이 있는 메소드 실행
        final Junit4Test junit4Test = clazz.getConstructor().newInstance();
        final Method[] methods = clazz.getMethods();
        for (final Method method : methods) {
            invokeByAnnotation(junit4Test, method);
        }
    }

    private void invokeByAnnotation(final Junit4Test junit4Test, final Method method) throws IllegalAccessException, InvocationTargetException {
        if (method.isAnnotationPresent(MyTest.class)) {
            method.invoke(junit4Test);
        }
    }
}