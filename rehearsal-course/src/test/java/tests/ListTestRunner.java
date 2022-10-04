package tests;

public class ListTestRunner {

    public static void main(String[] args) {

        ListTestRunner.runManualTest();

        //ListTestRunner.runJUnit5();
    }

    public static void runManualTest() {
        ListJUnitTest t = new ListJUnitTest();
        t.setUp();
        t.testAppend();
        t.testFind();
        t.testListOfObjects();
        t.testNext();
        t.testRemove();
        t.testNext();
    }
}
