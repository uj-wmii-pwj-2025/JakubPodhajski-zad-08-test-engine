package uj.wmii.pwj.anns;

public class MyBeautifulTestSuite {

    @MyTest
    public void testSoemthing() {
        System.out.println("I'm testing something!");
    }

    @MyTest(params = {"a param", "b param", "c param. Long, long C param."})
    public void testWithParam(String param) {
        System.out.printf("I was invoked with parameter: %s\n", param);
    }

    public void notATest() {
        System.out.println("I'm not a test.");
    }

    @MyTest
    public void imFailue() {
        System.out.println("I AM EVIL.");
        throw new NullPointerException();
    }

    @MyTest(params = {"5"}, expectedResult = "25")
    public int imSuccess(String param) {
        System.out.println("I AM GOOD.");
        return Integer.parseInt(param) * Integer.parseInt(param);
    }
    @MyTest(params = {"5"}, expectedResult = "24")
    public int imnotSuccess(String param) {
        System.out.println("I AM NOT SUCCESS.");
        return Integer.parseInt(param) * Integer.parseInt(param);
    }

    @MyTest(params = {"5"})
    public int imNotVoid(String param) {
        System.out.println("I AM NOT VOID.");
        return Integer.parseInt(param) * Integer.parseInt(param);
    }

    @MyTest(params = {"0"}, expectedResult = "???")
    public int imMathExpert(String param){
        System.out.println("I AM A MATH EXPERT.");
        int a = Integer.parseInt(param);
        return a/0;
    }
}
