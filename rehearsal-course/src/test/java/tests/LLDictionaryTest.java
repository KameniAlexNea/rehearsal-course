package tests;

import coen352.lelement.LLDictionary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class LLDictionaryTest {

    private static LLDictionary<Integer, String> dict;

    @BeforeEach
    public void setUp() {
        dict= new LLDictionary<>(10);
    }

    @Test
    public void testClear() {
        dict.insert(0, "element");
        assertEquals(1, dict.size());
        dict.clear();
        assertEquals(0, dict.size(), "clear failed, size is non zero");
    }

    @Test
    public void testInsert() {
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");
        
        assertEquals("grey", dict.find(3), "insert failed, cant find the element");
    }

    @Test
    public void testRemove() {

        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");

        //assertEquals("1:blue , 2:yellow , 3:grey ,", dict.toString());
        assertEquals("blue", dict.remove(1), "remove failed");

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

        assertEquals("grey", dict.find(3), "Find failed");
    }

    @Test
    public void testSize() {
        dict.clear();
        dict.insert(0, "red");

        assertEquals(1, dict.size(), "size failed, size is not as expected");
    }

}
