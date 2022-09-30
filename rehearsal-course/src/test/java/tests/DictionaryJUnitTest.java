package tests;

import coen352.dictionnary.ADTDictionary;
import coen352.delement.DLLDictionary;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DictionaryJUnitTest {

    private static ADTDictionary<Integer, String> dict;

    @BeforeAll
    public void setUp() {
        //dict= new LLDictionary<Integer, String>(10);
        dict = new DLLDictionary<Integer, String>(10);

        //please comment out the one you dont want to test.
    }

    @Test
    public void testClear() {
        dict.clear();
        assertEquals(0, dict.size(), "clear failed, size is non zero");
    }

    @Test
    public void testInsert() {
        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");
        assertEquals("insert failed, cant find the element", "grey", dict.find(3));
    }

    @Test
    public void testRemove() {

        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");

        //assertEquals("1:blue , 2:yellow , 3:grey ,", dict.toString());
        assertEquals("remove failed", "blue", dict.remove(1));

    }

    @Test
    public void testRemoveAny() {
        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");
        int size = dict.size();
        dict.removeAny();
        int sizeAfterRemoved = dict.size();
        assertNotEquals(size, sizeAfterRemoved, "the size is equal");
    }

    @Test
    public void testFind() {

        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");

        assertEquals("Find failed", dict.find(3), "grey");
    }

    @Test
    public void testSize() {
        dict.clear();
        dict.insert(0, "red");

        assertEquals(1, dict.size(), "size failed, size is not as expected");
    }

}
