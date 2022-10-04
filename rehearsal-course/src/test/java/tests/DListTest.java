package tests;

import coen352.delement.DList;
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
public class DListTest {
    
    private static DList<Integer> list;
    
    public DListTest() {
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
        list = new DList<>();
    }
    
    @AfterEach
    public void tearDown() {
        list.clear();
    }

    @Test
    public void testRemove() {
        list.append(1);
        
        assertEquals(1, (int) list.remove());
        
        assertEquals(0, list.length());
    }
    
    @Test
    public void testInsert() {
        // to be completed
    }
    
    @Test
    public void testToString() {
        // to be completed
    }
    
    @Test
    public void testAppend() {
        list.append(10);
        assertEquals(1, list.length());
        assertEquals("< | 10 >", list.toString());
        list.append(20);
        assertEquals(2, list.length());
        list.append(15);
        assertEquals(3, list.length());
        assertEquals("< | 10 20 15 >", list.toString());
    }
}
