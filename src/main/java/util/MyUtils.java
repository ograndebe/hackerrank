package util;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyUtils {

    public static void printArray(String label, int[] arr) {
        System.out.printf("%s -> %s\n", label, IntStream.of(arr).boxed().collect(Collectors.toList()).toString());
    }
    public static void printArray(String label, int[] arr, int begin, int end) {
        final ArrayList<Integer> toShow = new ArrayList<>(end - begin);
        for (int i = begin; i < end; i++ ) {
            toShow.add(arr[i]);
        }
        System.out.printf("%s -> %s\n", label, toShow);
    }


    public static void main(String[] args) {

        System.out.println(10 >> 1);
        System.out.println(10 / 2);
        System.out.println(20 >> 1);
        System.out.println(20 / 2);
        System.out.println(30 >> 1);
        System.out.println(30 / 2);
        System.out.println(15 >> 1);
        System.out.println(15 / 2);

    }
}
