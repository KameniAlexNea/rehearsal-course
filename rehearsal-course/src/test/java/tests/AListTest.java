package tests;

import coen352.list.AList;
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
public class AListTest {
    
    private static AList<Integer> list;
    
    public AListTest() {
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
        list = new AList<>();
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
        // to be completed
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
