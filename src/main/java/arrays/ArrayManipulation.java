package arrays;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayManipulation {

    static long arrayManipulationOld(int n, int[][] queries) {
        final HashMap<Long, Long> map = new HashMap<>();

        for (int row= 0; row < queries.length; row++) {
            long a = queries[row][0];
            long b = queries[row][1];
            long k = queries[row][2];


            if (k > 0) {
                for (long i = a; i <= Math.min(b,n); i++) {
                    if (map.containsKey(i)) {
                        map.put(i, map.get(i)+k);
                    } else {
                        map.put(i, k);
                    }
                }
            }
        }

        final Optional<Long> bigger = map.values().stream().max(Long::compareTo);

        return bigger.get();
    }

    static long arrayManipulationOld2(int n, int[][] queries) {
        long[] arr = new long[n];

        long bigger = 0;
        for (int row= 0; row < queries.length; row++) {
            int a = queries[row][0];
            int b = queries[row][1];
            long k = queries[row][2];


            if (k > 0) {
                for (int i = a; i <=b ; i++) {
                    arr[i-1] += k;
                    if (arr[i-1] > bigger ) bigger = arr[i-1];
                }
            }
        }

        return bigger;
    }

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];

        for (int row= 0; row < queries.length; row++) {
            int a = queries[row][0];
            int b = queries[row][1];
            long k = queries[row][2];
            arr[a-1] += k;
            if (b < n) arr[b] -= k;
        }

        long bigger = 0;
        long s = 0;
        for (int i = 0; i < n ; i++) {
            s += arr[i];
            if (s > bigger) bigger = s;
        }

        return bigger;
    }

    @Test
    public void example0() {
        int[][] arr = {
                {1,2,100},
                {2,5,100},
                {3,4,100}
        };
        long result = arrayManipulation(5,arr);
        assertEquals(200L,result);
    }

    private int[][] read(String resource) {
        final Scanner scanner = new Scanner(ArrayManipulation.class.getResourceAsStream(resource));
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        return queries;
    }

    @Test
    public void example4() {
        int[][] arr = read("/arrays.example4.txt");
        long result = arrayManipulation(4000,arr);
        assertEquals(7542539201L,result);

    }

    @Test
    public void example7() {
        int[][] arr = read("/input07.txt");
        long result = arrayManipulation(10000000,arr);
        assertEquals(2497169732L,result);

    }

    @Test
    public void example14() {
        int[][] arr = {
                {1,5,3},
                {4,8,7},
                {6,9,1},
        };
        long result = arrayManipulation(10,arr);
        assertEquals(10L,result);
    }

    @Test
    public void example15() {
        int[][] arr = {
                {2,6,8},
                {3,5,7},
                {1,8,1},
                {5,9,15},
        };
        long result = arrayManipulation(10,arr);
        assertEquals(31L,result);
    }


}
