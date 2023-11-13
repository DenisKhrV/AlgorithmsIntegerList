package pro.sky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        IntegerListImpl integerList = new IntegerListImpl();
//        int[] arr = IntegerListImpl.generateRandomArray();
//        int[] arr2 = Arrays.copyOf(arr, arr.length);
//        int[] arr3 = Arrays.copyOf(arr, arr.length);
////        System.out.println(Arrays.toString(arr));
//
//        long start = System.currentTimeMillis();
//        IntegerListImpl.sortBubble(arr);
//        System.out.println(System.currentTimeMillis() - start);
//
//        long start2 = System.currentTimeMillis();
//        IntegerListImpl.sortSelection(arr2);
//        System.out.println(System.currentTimeMillis() - start2);
//
//        long start3 = System.currentTimeMillis();
//        IntegerListImpl.sortInsertion(arr3);
//        System.out.println(System.currentTimeMillis() - start3);
        IntegerListImpl integerList = new IntegerListImpl();
        integerList.add(10);
        integerList.add(23);
        integerList.add(4);
        integerList.add(7);
        Integer[] expectedArray = new Integer[]{4, 7, 10, 23};
        integerList.sort(integerList.toArray());
        Integer[] actualArray = integerList.toArray();
        System.out.println(Arrays.toString(actualArray));
    }
}