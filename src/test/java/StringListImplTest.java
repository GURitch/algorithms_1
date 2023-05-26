
import org.example.StringList;
import org.example.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class StringListImplTest {

    private StringList stringList;

    @BeforeEach
    public void setup() {
        stringList = new StringListImpl(3);
    }

    @Test
    public void testExceptionStringListImpl(){
        stringList.add("Apple");
        stringList.add("Banana");
        assertThrows(IllegalArgumentException.class, ()->stringList.add(null));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.add(-1,"Orange"));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.add(stringList.size()+1,"Orange"));
        assertThrows(IllegalArgumentException.class, ()->stringList.set(0,null));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.set(-1,"Orange"));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.set(stringList.size()+1,"Orange"));
        assertThrows(IllegalArgumentException.class, ()->stringList.remove(null));
        assertThrows(NoSuchElementException.class, ()->stringList.remove("Orange"));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.remove(stringList.size()+1));
        assertThrows(IllegalArgumentException.class, ()->stringList.contains(null));
        assertThrows(IllegalArgumentException.class, ()->stringList.indexOf(null));
        assertThrows(IllegalArgumentException.class, ()->stringList.lastIndexOf(null));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, ()->stringList.get(stringList.size()+1));
        assertThrows(IllegalArgumentException.class, ()->stringList.equals(null));

    }

    @Test
    public void testAdd() {
        stringList.add("Apple");
        stringList.add("Banana");

        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("Apple"));
        assertTrue(stringList.contains("Banana"));
    }

    @Test
    public void testAddAtIndex() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add(1, "Orange");

        assertEquals(3, stringList.size());
        assertEquals("Apple", stringList.get(0));
        assertEquals("Orange", stringList.get(1));
        assertEquals("Banana", stringList.get(2));
    }

    @Test
    public void testSet() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.set(1, "Orange");

        assertEquals(2, stringList.size());
        assertEquals("Apple", stringList.get(0));
        assertEquals("Orange", stringList.get(1));
    }

    @Test
    public void testRemoveByItem() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.remove("Banana");

        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("Apple"));
        assertFalse(stringList.contains("Banana"));
        assertTrue(stringList.contains("Orange"));
    }

    @Test
    public void testRemoveByIndex() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.remove(1);

        assertEquals(2, stringList.size());
        assertEquals("Apple", stringList.get(0));
        assertEquals("Orange", stringList.get(1));
    }

    @Test
    public void testIndexOf() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        assertEquals(1, stringList.indexOf("Banana"));
    }

    @Test
    public void testLastIndexOf() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.add("Banana");

        assertEquals(3, stringList.lastIndexOf("Banana"));
    }

    @Test
    public void testGet() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        assertEquals("Banana", stringList.get(1));
    }

    @Test
    public void testEquals() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        StringList otherList = new StringListImpl();
        otherList.add("Apple");
        otherList.add("Banana");
        otherList.add("Orange");

        assertTrue(stringList.equals(otherList));
    }

    @Test
    public void testSize() {
        assertEquals(0, stringList.size());

        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        assertEquals(3, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stringList.isEmpty());

        stringList.add("Apple");
        stringList.add("Banana");

        assertFalse(stringList.isEmpty());
    }

    @Test
    public void testClear() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        stringList.clear();

        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testToArray() {
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        String[] array = stringList.toArray();

        assertArrayEquals(new String[]{"Apple", "Banana", "Orange"}, array);
    }
}