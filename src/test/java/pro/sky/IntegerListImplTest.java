package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exceptions.ElementNotFoundException;
import pro.sky.exceptions.InvalidIndexException;
import pro.sky.exceptions.NullItemException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class IntegerListImplTest {
    IntegerListImpl integerList = new IntegerListImpl();

    @BeforeEach
    public void setUp() {
        integerList.add(10);
        integerList.add(23);
        integerList.add(4);
        integerList.add(7);
    }


    @Test
     void add_success() {
        Integer expected = 55;
        integerList.add(55);
        Integer actual = integerList.get(4);
        assertTrue(integerList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void testAdd_success() {
        Integer expected = 44;
        integerList.add(1,44);
        Integer actual = integerList.get(1);
        assertTrue(integerList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void set_success() {
        Integer actual = integerList.set(2, 33);
        Integer expected = integerList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    void set_shouldReturnInvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> integerList.set(20, 22));
    }

    @Test
    void set_shouldReturnNullItemException() {
        Integer s = null;
        assertThrows(NullItemException.class, () -> integerList.set(2, s));
    }

    @Test
    void remove_success() {
        Integer expected = 23;
        Integer actual = integerList.remove(23);
        assertFalse(integerList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void remove_failing() {
        int excepted = 999;
        assertThrows(ElementNotFoundException.class, () -> integerList.remove(excepted));
    }

    @Test
    void testRemoveByIndex_success() {
        Integer expected = 4;
        Integer actual = integerList.removeByIndex(2);
        assertFalse(integerList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void testRemoveByIndex_failing() {
        assertThrows(InvalidIndexException.class, () -> integerList.removeByIndex(20));
    }

    @Test
    void contains_success() {
        Integer expected = 10;
        assertTrue(integerList.contains(expected));
    }

    @Test
    void indexOf_success() {
        int expected = 1;
        int actual = integerList.indexOf(23);
        assertEquals(expected, actual);
    }

    @Test
    void indexOf_failing() {
        int expected = -1;
        int actual = integerList.indexOf(888);
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf_success() {
        int expected = 1;
        int actual = integerList.lastIndexOf(23);
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf_failing() {
        int expected = -1;
        int actual = integerList.indexOf(888);
        assertEquals(expected, actual);
    }

    @Test
    void get_success() {
        Integer expected = 4;
        Integer actual = integerList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    void get_shouldReturnInvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> integerList.get(20));
    }

    @Test
    void testEquals_success() {
        List<Integer> otherList = List.of(10, 23, 4, 7);
        integerList = new IntegerListImpl(4);
        integerList.add(10);
        integerList.add(23);
        integerList.add(4);
        integerList.add(7);

        assertEquals(Arrays.toString(integerList.getStorage()), otherList.toString());

    }

    @Test
    void size_success() {
        int expectedInt = 4;
        int actualInt = integerList.size();
        assertEquals(expectedInt, actualInt);
    }

    @Test
    void isEmpty_success() {
        integerList = new IntegerListImpl();
        assertTrue(integerList.isEmpty());
    }

    @Test
    void clear_success() {
        int expectedSize = 0;
        integerList.clear();

        assertEquals(expectedSize, integerList.getSize());
    }

    @Test
    void toArray_success() {
        //Подготовка ожидаемого результата
        Integer[] expectedArray = new Integer[]{10, 23, 4, 7};

        //Начало теста
        Integer[] actualArray = integerList.toArray();
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
    }

    @Test
    void add_growSuccess() {
        Integer[] expectedArray = new Integer[15];
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        Integer[] actualArray = integerList.toArray();
        assertEquals(expectedArray.length, actualArray.length);
    }
}