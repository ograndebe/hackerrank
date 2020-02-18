package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinimumBribes {

    static void calculatedMinimumBribes(int[] q) {

        int bribes = 0;
        for (int i =0 ; i < q.length ; i++) {
            int initialPerson = i+1;

            int nextPerson = i+1 <= q.length-1? q[i+1]:Integer.MAX_VALUE;
            int nextNextPerson = i+2 <= q.length-1? q[i+2]:Integer.MAX_VALUE;
            if (q[i] > nextPerson || q[i] > nextNextPerson) {
                int distance = Math.abs(initialPerson-q[i]);
                if (distance >= 3) {
                    bribes = -999;
                    break;
                } else {
                    bribes += distance;
                }
            }
        }

        if (bribes == -999) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }

    }


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int bribes = 0;
//        show(q, bribes);
        int[] n = new int[q.length];

        for (int i = 0; i < q.length ; i++) {
            n[i] = i+1;
        }
//        show(n, bribes);
        for (int i = 0 ; i < q.length ; i++) {
            if (q[i] != n[i]) {
//                System.out.printf("q[i] != n[i] %s %s\n", q[i], n[i]);
                if (i+1 < q.length && q[i] == n[i+1]) {
                    int f = n[i+1];
                    n[i+1] = n[i];
                    n[i] = f;
                    bribes++;
                } else if (i+2 < q.length && q[i] == n[i+2]) {
                    int n1 = n[i];
                    int n2 = n[i+1];
                    n[i] = n[i+2];
                    n[i+1] = n1;
                    n[i+2] = n2;
                    bribes+=2;
                }

                if (q[i] != n[i]) {
                    bribes = Integer.MAX_VALUE;
                    break;
                }
            }
//            show(n, bribes);
        }

        if (bribes == Integer.MAX_VALUE) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }

    }

    private static void show(int[] arr, int bribes) {
        System.out.print(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(" "+bribes);
    }


    public static void main(String[] args) {
//        int[] arr = {5, 1, 2, 3, 7, 8, 6, 4}; //chaos
//        minimumBribes(arr);
        int[] arr2 = {1, 2 ,5 ,3 ,7 ,8 ,6 ,4}; //7
        minimumBribes(arr2);
    }

}
