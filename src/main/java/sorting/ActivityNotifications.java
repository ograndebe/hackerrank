package sorting;

import hashtables.FreqQuery;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityNotifications {


    static int activityNotifications(int[] expenditure, int d) {

        int auxArray[] = new int[201];

        for(int i = 0; i < d; i++){
            auxArray[expenditure[i]]++;
        }

        int middleIndex = d/2;
        boolean odd = d%2!= 0;
        int alerts = 0;
        LinkedList<Integer> l = new LinkedList<>();
        for (int index = d; index < expenditure.length ; index++) {
            double median  =  calcMedian(auxArray, middleIndex,  odd);
            int expense = expenditure[index];
            if (expense >= 2*median) {
                alerts++;
//                    System.out.printf(" **%s",alerts);
                l.add(index);
            }

            auxArray[expenditure[index]]++;
            auxArray[expenditure[index - d]]--;
        }
        System.out.println(l);
        return alerts;

    }

    public static double calcMedian(int[] auxArray, int middleIndex, boolean odd){
        //recreating until the middle
//        int orderedUntilTheMiddle[] = new int[middleIndex+1];
        int newIndex = 0;
        int last = -1;
        for(int i = 0; i < auxArray.length; i++){
            int elementCounting = auxArray[i];
            if (elementCounting > 0) {
                newIndex += elementCounting;
                if (newIndex >= middleIndex) {
                    if (newIndex == middleIndex) {
                        return odd || elementCounting > 1?i:(last+i)/2D;
                    } else {
                        return i;
                    }
                }
                last = i;
            }
        }

        return -1;
    }

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


    static int activityNotificationsBest(int[] expenditure, int d) {

        int auxArray[] = new int[201];

        for(int i = 0; i < d; i++){
            auxArray[expenditure[i]]++;
        }

        int middleIndex = d/2;
        boolean odd = d%2!= 0;
        int alerts = 0;
        for (int index = d; index < expenditure.length ; index++) {
            double median  =  calcMedian(auxArray, middleIndex,  odd);
            int expense = expenditure[index ];
            if (expense >= 2*median) {
                alerts++;
//                    System.out.printf(" **%s",alerts);
            }

            auxArray[expenditure[index]]++;
            auxArray[expenditure[index - d]]--;
        }
        return alerts;

    }

    public static double calcMedianBest(int[] auxArray, int middleIndex, boolean odd){
        //recreating until the middle
        int orderedUntilTheMiddle[] = new int[middleIndex+1];
        int newIndex = 0;
        for(int i = 0; i < auxArray.length; i++){
            int elementCounting = auxArray[i];
            if (elementCounting > 0) {
                newIndex += elementCounting;
                if (newIndex >= middleIndex) {
                    newIndex-= elementCounting;
                    for (int x = 0; x < elementCounting ; x++) {
                        orderedUntilTheMiddle[newIndex++] = i;
                        if (newIndex > middleIndex) {
                            x = elementCounting;
                            i = auxArray.length;
                        }
                    }

                }
            }
        }
//        System.out.printf("%s -> %s\n", middleIndex, orderedUntilTheMiddle[middleIndex]);
        double median;
        if (odd) {
            median = orderedUntilTheMiddle[middleIndex];
        } else {
            median = (orderedUntilTheMiddle[middleIndex-1]+orderedUntilTheMiddle[middleIndex])/2D;
        }

        return median;
    }


    @Test
    public void test00() throws IOException {
        final int result = runTest("/sorting/activityNotifications/input00.txt");
        final int output = getOutput("/sorting/activityNotifications/output00.txt");
        assertEquals(output, result);
    }


    @Test
    public void test01() throws IOException {
        final int result = runTest("/sorting/activityNotifications/input01.txt");
        final int output = getOutput("/sorting/activityNotifications/output01.txt");
        assertEquals(output, result);
    }


    @Test
    public void test06() throws IOException {
        final int result = runTest("/sorting/activityNotifications/input06.txt");
        final int  output = getOutput("/sorting/activityNotifications/output06.txt");
        assertEquals(output, result);
    }

    @Test
    public void test07() throws IOException {
        final int result = runTest("/sorting/activityNotifications/input07.txt");
        final int  output = getOutput("/sorting/activityNotifications/output07.txt");
        assertEquals(output, result);
    }


    private Integer getOutput(String resource){
        final Scanner scanner = new Scanner(FreqQuery.class.getResourceAsStream(resource));

        LinkedList<Integer> resultList = new LinkedList<>();
        boolean ok = true;
        do {
            try {
                int q = scanner.nextInt();
                resultList.add(new Integer(q));
            } catch (NoSuchElementException e) {
                ok = false;
            }
        } while(ok);

        scanner.close();

        return resultList.get(0);
    }

    public static int runTest(String resource) throws IOException {
        final Scanner scanner = new Scanner(ActivityNotifications.class.getResourceAsStream(resource));
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        scanner.close();

        return result;

    }


}
