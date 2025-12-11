package uj.wmii.pwj.anns;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTestEngine {

    private final String className;
    private static final Printer printer = new Printer();
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify test class name");
            System.exit(-1);
        }
        Printer.printLogo();
        String className = args[0].trim();
        System.out.printf("Testing class: %s\n", className);
        MyTestEngine engine = new MyTestEngine(className);
        engine.runTests();
    }

    public MyTestEngine(String className) {
        this.className = className;
    }

    public void runTests() {
        final Object unit = getObject(className);
        List<Method> testMethods = getTestMethods(unit);
        int successCount = 0;
        int failCount = 0;
        int errorCount = 0;
        for (Method m: testMethods) {
            TestResult result = launchSingleMethod(m, unit);
            if (result == TestResult.SUCCESS) successCount++;
            else if(result == TestResult.FAIL) failCount++;
            else errorCount++;
        }
        Printer.summarize(successCount, failCount, errorCount);
    }

    private TestResult launchSingleMethod(Method m, Object unit) {
        try {
            String[] params = m.getAnnotation(MyTest.class).params();
            List<Object> actual_result = new java.util.ArrayList<>();
            if (params.length == 0) {
                actual_result.add(m.invoke(unit));
            } else {
                for (String param: params) {
                    actual_result.add(m.invoke(unit, param));
                }
            }
            String expected_result = m.getAnnotation(MyTest.class).expectedResult();
            for (Object actual: actual_result) {
                if (actual == null || expected_result.isEmpty()) continue;
                if (!actual.toString().equals(expected_result)) {
                    Printer.printFail(m.getName());
                    return TestResult.FAIL;
                }
            }
            Printer.printSuccess(m.getName());
            return TestResult.SUCCESS;
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            return TestResult.ERROR;
        }
    }

    private static List<Method> getTestMethods(Object unit) {
        Method[] methods = unit.getClass().getDeclaredMethods();
        return Arrays.stream(methods).filter(
                m -> m.getAnnotation(MyTest.class) != null).collect(Collectors.toList());
    }

    private static Object getObject(String className) {
        try {
            Class<?> unitClass = Class.forName(className);
            return unitClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            return new Object();
        }
    }
}
