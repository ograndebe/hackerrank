package sorting;

import hashtables.FreqQuery;
import org.junit.jupiter.api.Test;
import util.MyUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountInversions {

    // Complete the countInversions function below.
    public static long countInversions(int[] a){
        int n = a.length;

        // Base Case
        if(n <= 1) {
            return 0;
        }

        // Recursive Case
        int mid = n >> 1;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        long inversions = countInversions(left) + countInversions(right);

        int range = n - mid;
        int iLeft = 0;
        int iRight = 0;
        for(int i = 0; i < n; i++) {
            if(
                    iLeft < mid
                            && (
                            iRight >= range || left[iLeft] <= right[iRight]
                    )
            ) {
                a[i] = left[iLeft++];
                inversions += iRight;
            }
            else if(iRight < range) {
                a[i] = right[iRight++];
            }
        }

        return inversions;
    }
    static long countInversionsd(int[] arr) {
        MyUtils.printArray("inicial",arr);
        long swaps = sort(arr, 0, arr.length-1);

        return swaps;
    }

    private static void swap(int[] arr, int i, int j) {
        int vi = arr[i];
        arr[i] = arr[j];
        arr[j] = vi;
    }

    private static long sort(int[] arr, int begin, int end) {
        long swaps = 0;
        if (end-begin == 1) {
            if (arr[begin] > arr[end]) {
                swap(arr, begin, end);
                swaps++;
            }
        } else if (end-begin > 1 ) {
            int middle = begin+((end-begin)/2);
            long swaps1 = sort(arr, begin , middle);
            long swaps2 = sort(arr, middle+1 , end);
            long swapsMerge = merge(arr, begin, middle, end);
            return swaps1+swaps2+swapsMerge;
        }
        return swaps;
    }

    private static long merge(int[] arr, int i, int middle, int j) {
        int[] cache = new int[j-i+1];
        int i1 = i;
        int i2 = middle+1;

        int mi = 0;
//        boolean left = true;
        long swaps = 0;
        while (i1 <= middle && i2 <= j) {
            if (arr[i1] <= arr[i2]) {
                cache[mi++] = arr[i1++];

//                if (!left) swaps++;
//                left = true;
            } else {
                cache[mi++] = arr[i2++];
                swaps++;
//                if (left) swaps++;
//                left = false;
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




    @Test
    public void test00() throws IOException {
        final LinkedList<Long> result = testExample("00");
        final List<Long> expected = getOutput("00");
        assertEquals(expected, result);
    }

    @Test
    public void test01() throws IOException {
        final LinkedList<Long> result = testExample("01");
        final List<Long> expected = getOutput("01");
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
