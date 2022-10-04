package tests;

public class DictionaryManualTest {

    public static void main(String[] args) {
        DictionaryManualTest.runManualDLLTest();
        DictionaryManualTest.runManualLLTest();
    }

    public static void runManualDLLTest() {
        DLLDictionaryTest t = new DLLDictionaryTest();
        DLLDictionaryTest.setUp();
        t.testClear();
        t.testFind();
        t.testInsert();
        t.testRemove();
        t.testRemoveAny();
        t.testSize();
    }
    
    public static void runManualLLTest() {
        LLDictionaryTest t = new LLDictionaryTest();
        DLLDictionaryTest.setUp();
        t.testClear();
        t.testFind();
        t.testInsert();
        t.testRemove();
        t.testRemoveAny();
        t.testSize();
    }

}
