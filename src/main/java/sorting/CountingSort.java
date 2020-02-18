package sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountingSort {


    void sort(int[] arr, int max) {
        int[] count = new int[max+1];

        for (int i = 0; i < arr.length; i++) count[arr[i]]++;

        for (int i = 1; i <= max; ++i)
            count[i] += count[i - 1];

        int[] output = new int[arr.length + 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }


    private String toString(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList()).toString();
    }

    @Test
    public void test1() {
        int[] arr = {5, 65, 35, 33, 31, 88, 2, 6, 7, 22, 66, 77, 99, 55, 44, 44, 44, 44, 54, 11, 89, 78, 54, 32, 78, 98, 15, 54, 96, 21};
//        int[] arr = {5, 4, 7, 6, 2};
        System.out.println(toString(arr));
        sort(arr,100);
        System.out.println(toString(arr));


    }


}
