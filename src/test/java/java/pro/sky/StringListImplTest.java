package java.pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.StringListImpl;
import pro.sky.exceptions.ElementNotFoundException;
import pro.sky.exceptions.InvalidIndexException;
import pro.sky.exceptions.NullItemException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class StringListImplTest {
    StringListImpl stringList = new StringListImpl();

    @BeforeEach
    public void setUp() {
        stringList.add("123");
        stringList.add("456");
        stringList.add("Hello");
        stringList.add("World");
    }


    @Test
    void add_success() {
        String expected = "Test";
        stringList.add("Test");
        String actual = stringList.get(4);
        assertTrue(stringList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void testAdd_success() {
        String expected = "Test";
        stringList.add(1,"Test");
        String actual = stringList.get(1);
        assertTrue(stringList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void set_success() {
        String actual = stringList.set(2, "Test");
        String expected = stringList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    void set_shouldReturnInvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> stringList.set(20, "Test"));
    }

    @Test
    void set_shouldReturnNullItemException() {
        String s = null;
        assertThrows(NullItemException.class, () -> stringList.set(2, s));
    }

    @Test
    void remove_success() {
        String expected = "Hello";
        String actual = stringList.remove("Hello");
        assertFalse(stringList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void remove_failing() {
        String excepted = "Hello123";
        assertThrows(ElementNotFoundException.class, () -> stringList.remove(excepted));
    }

    @Test
    void testRemove_success() {
        String expected = "Hello";
        String actual = stringList.remove(2);
        assertFalse(stringList.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void testRemove_failing() {
        assertThrows(InvalidIndexException.class, () -> stringList.remove(20));
    }

    @Test
    void contains_success() {
        String expected = "Hello";
        assertTrue(stringList.contains(expected));
    }

    @Test
    void indexOf_success() {
        int expected = 2;
        int actual = stringList.indexOf("Hello");
        assertEquals(expected, actual);
    }

    @Test
    void indexOf_failing() {
        int expected = -1;
        int actual = stringList.indexOf("Hello123");
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf_success() {
        int expected = 2;
        int actual = stringList.indexOf("Hello");
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf_failing() {
        int expected = -1;
        int actual = stringList.indexOf("Hello123");
        assertEquals(expected, actual);
    }

    @Test
    void get_success() {
        String expected = "Hello";
        String actual = stringList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    void get_shouldReturnInvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> stringList.get(20));
    }

    @Test
    void testEquals_success() {
        List<String> otherList = List.of("123", "456", "Hello", "World");
        stringList = new StringListImpl(4);
        stringList.add("123");
        stringList.add("456");
        stringList.add("Hello");
        stringList.add("World");

        assertEquals(Arrays.toString(stringList.getStorage()), otherList.toString());

    }

    @Test
    void size_success() {
        int expectedInt = 4;
        int actualInt = stringList.size();
        assertEquals(expectedInt, actualInt);
    }

    @Test
    void isEmpty_success() {
        stringList = new StringListImpl();
        assertTrue(stringList.isEmpty());
    }

    @Test
    void clear_success() {
        int expectedSize = 0;
        stringList.clear();

        assertEquals(expectedSize, stringList.getSize());
    }

    @Test
    void toArray_success() {
        //Подготовка ожидаемого результата
        String[] expectedArray = new String[]{"123", "456", "Hello", "World"};

        //Начало теста
        String[] actualArray = stringList.toArray();
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));


    }
}