package sorting;

import hashtables.FreqQuery;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        long swaps = sort(arr, 0, arr.length-1, 0);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(swaps);
        return swaps;
    }

    private static long sort(int[] arr, int i, int j, long swaps) {
        if (j-i <= 1) {
            if (arr[i] > arr[j]) {
                swap(arr, i, j);
                return swaps+1;
            } else {
                return swaps;
            }
        } else {
            int middle = i+(j-i)/2;
            long swaps1 = sort(arr, i , middle, swaps);
            long swaps2 = sort(arr, middle+1 , j, swaps);
            long swapsMerge = merge(arr, i, middle, j);
            return swaps1+swaps2+swapsMerge;
        }
    }

    private static long merge(int[] arr, int i, int middle, int j) {
        int[] cache = new int[j-i+1];
        int i1 = i;
        int i2 = middle+1;

        int mi = 0;
        boolean left = true;
        long swaps = 0;
        while (i1 <= middle && i2 <= j) {
            if (arr[i1] <= arr[i2]) {
                cache[mi++] = arr[i1++];
                if (!left) swaps++;
                left = true;
            } else {
                cache[mi++] = arr[i2++];
                if (left) swaps++;
                left = false;
            }
        }

        while (i1 <= middle) {
            cache[mi++] = arr[i1++];
        }
        while (i2 <= j) {
            cache[mi++] = arr[i2++];
        }

        for (int x = i, a = 0 ; x < j ; x++) arr[x] = cache[a++];
        return swaps;
    }

    private static void swap(int[] arr, int i, int j) {
        int vi = arr[i];
        arr[i] = arr[j];
        arr[j] = vi;
    }


    @Test
    public void test00() throws IOException {
        final LinkedList<Long> result = testExample("00");
        final List<Long> expected = getOutput("00");
        assertEquals(expected, result);
    }


    @Test
    public void test14() throws IOException {
        final LinkedList<Long> result = testExample("14");
        final List<Long> expected = getOutput("14");
        assertEquals(expected, result);
    }

    @Test
    public void test15() throws IOException {
        final LinkedList<Long> result = testExample("15");
        final List<Long> expected = getOutput("15");
        assertEquals(expected, result);
    }



    public static LinkedList<Long> testExample(String example) throws IOException {
        final Scanner scanner = new Scanner(CountInversions.class.getResourceAsStream(String.format("/sorting/countInversions/input%s.txt", example)));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        LinkedList<Long> results = new LinkedList<>();
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            results.add(result);

        }

        scanner.close();
        return results;
    }
    private List<Long> getOutput(String example){
        final Scanner scanner = new Scanner(FreqQuery.class.getResourceAsStream(String.format("/sorting/countInversions/output%s.txt", example)));

        LinkedList<Long> resultList = new LinkedList<>();
        boolean ok = true;
        do {
            try {
                int q = scanner.nextInt();
                resultList.add(new Long(q));
            } catch (NoSuchElementException e) {
                ok = false;
            }
        } while(ok);

        scanner.close();

        return resultList;
    }



}
