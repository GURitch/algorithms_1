package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class IntegerListImplTest {

    private IntegerList IntegerList;

    @BeforeEach
    public void setup() {
        IntegerList = new IntegerListImpl(3);
    }

    @Test
    public void testExceptionIntegerListImpl() {
        IntegerList.add(1);
        IntegerList.add(2);
        assertThrows(IllegalArgumentException.class, () -> IntegerList.add(null));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.add(-1, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.add(IntegerList.size() + 1, 3));
        assertThrows(IllegalArgumentException.class, () -> IntegerList.set(0, null));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.set(-1, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.set(IntegerList.size() + 1, 3));
        assertThrows(IllegalArgumentException.class, () -> IntegerList.remove(null));
        Integer x = 3;
        assertThrows(NoSuchElementException.class, () -> IntegerList.remove(x));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.remove(IntegerList.size() + 1));
        assertThrows(IllegalArgumentException.class, () -> IntegerList.contains(null));
        assertThrows(IllegalArgumentException.class, () -> IntegerList.indexOf(null));
        assertThrows(IllegalArgumentException.class, () -> IntegerList.lastIndexOf(null));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList.get(IntegerList.size() + 1));
        assertThrows(IllegalArgumentException.class, () -> IntegerList.equals(null));

    }

    @Test
    public void testAdd() {
        IntegerList.add(1);
        IntegerList.add(2);

        assertEquals(2, IntegerList.size());
        assertTrue(IntegerList.contains(1));
        assertTrue(IntegerList.contains(2));
    }

    @Test
    public void testAddAtIndex() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(1, 3);

        assertEquals(3, IntegerList.size());
        assertEquals(1, IntegerList.get(0));
        assertEquals(3, IntegerList.get(1));
        assertEquals(2, IntegerList.get(2));
    }

    @Test
    public void testSet() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.set(1, 3);

        assertEquals(2, IntegerList.size());
        assertEquals(1, IntegerList.get(0));
        assertEquals(3, IntegerList.get(1));
    }

    @Test
    public void testRemoveByItem() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);
        IntegerList.remove(2);

        assertEquals(2, IntegerList.size());
        assertTrue(IntegerList.contains(1));
        assertFalse(IntegerList.contains(3));
        assertTrue(IntegerList.contains(2));
    }

    @Test
    public void testRemoveByIndex() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);
        IntegerList.remove(1);

        assertEquals(2, IntegerList.size());
        assertEquals(1, IntegerList.get(0));
        assertEquals(3, IntegerList.get(1));
    }

    @Test
    public void testIndexOf() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        assertEquals(1, IntegerList.indexOf(2));
    }

    @Test
    public void testLastIndexOf() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);
        IntegerList.add(2);

        assertEquals(3, IntegerList.lastIndexOf(2));
    }

    @Test
    public void testGet() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        assertEquals(2, IntegerList.get(1));
    }

    @Test
    public void testEquals() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        IntegerList otherList = new IntegerListImpl();
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);

        assertTrue(IntegerList.equals(otherList));
    }

    @Test
    public void testSize() {
        assertEquals(0, IntegerList.size());

        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        assertEquals(3, IntegerList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(IntegerList.isEmpty());

        IntegerList.add(1);
        IntegerList.add(2);

        assertFalse(IntegerList.isEmpty());
    }

    @Test
    public void testClear() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        IntegerList.clear();

        assertEquals(0, IntegerList.size());
        assertTrue(IntegerList.isEmpty());
    }

    @Test
    public void testToArray() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer[] array = IntegerList.toArray();

        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void testToContains() {
        IntegerList.add(1);
        assertFalse(IntegerList.contains(2));
        assertTrue(IntegerList.contains(1));
    }
}