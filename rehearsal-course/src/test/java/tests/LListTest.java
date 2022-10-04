package tests;

import coen352.lelement.LList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alex
 */
public class LListTest {
    
    private static LList<Integer> list;
    
    public LListTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
        list = null;
    }
    
    @BeforeEach
    public void setUp() {
        list = new LList<>();
    }
    
    @AfterEach
    public void tearDown() {
        list.clear();
    }

    @Test
    public void testRemove() {
        list.append(1);
        assertEquals("< | 1 >", list.toString());
        
        assertEquals(1, (int) list.remove());
        
        assertEquals(0, list.length());
        
        assertEquals("< | >", list.toString());
        
        assertEquals(null, list.remove());
    }
    
    @Test
    public void testInsert() {
        // to complete
    }
    
    @Test
    public void testFind() {
        list.insert(39);
        list.insert(9);
        list.insert(5);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(1);
        assertEquals("< 39 9 | 5 4 3 2 1 >", list.toString());
        assertEquals(7, list.length());
        assertEquals(true, ListJUnitTest.find(list, 3));
        assertEquals(false, ListJUnitTest.find(list, 29));
        assertEquals(true, ListJUnitTest.find(list, 5));
    }
    
    @Test
    public void testAppend() {
        list.append(10);
        System.out.println(list.currPos());
        assertEquals("< | 10 >", list.toString());
        System.out.println(list.currPos());
        list.append(20);
        list.append(15);
        System.out.println(list.currPos());
        assertEquals("< | 10 20 15 >", list.toString());
    }
}
