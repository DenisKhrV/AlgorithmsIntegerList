package pro.sky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntegerListImpl integerList = new IntegerListImpl();
        int[] array = IntegerListImpl.generateRandomArray();
        System.out.println(Arrays.toString(array));
    }
}