package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int[] ordered = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            ordered[x] = x+1;
        }
        for (int x = 0; x < arr.length; x++) {
//            System.out.print(Arrays.stream(ordered).boxed().collect(Collectors.toList()));
            if (ordered[x] != arr[x]) {
                int swapIndex = getIndexOf(ordered, x, arr[x]);
                swaps ++;
                swap(ordered, x, swapIndex);
            }
//            System.out.printf(" %s\n",swaps);
        }
        return swaps;
    }
    static void swap(int[] arr, int i1, int i2) {
        int v1 = arr[i1];
        int v2 = arr[i2];
        arr[i1] = v2;
        arr[i2] = v1;

    }

    static int getIndexOf(int[] arr, int start, int element) {
        for (int i = start ; i <arr.length ; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }

    public static void main (String[] args) {
//        int[] arr={4,3,1,2}; // 3
//        int[] arr={2,3,4,1,5}; // 3
        int[] arr={1,3,5,2,4,6,7}; // 3
//        int[] arr={7, 1, 3, 2, 4, 5, 6}; // 5

        int result = minimumSwaps(arr);

        System.out.println(result);

    }
}
