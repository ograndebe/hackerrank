package sorting;

import hashtables.FreqQuery;
import org.junit.jupiter.api.Test;
import util.MyUtils;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityNotifications {


    static int activityNotifications(int[] expenditure, int d) {

        int counterArray[] = new int[201];

        for(int i = 0; i < d; i++){
            counterArray[expenditure[i]]++;
        }

        int middleIndex = d/2;
        boolean odd = d%2!= 0;
        if (odd) {
            middleIndex += 1;
        }
        int alerts = 0;
        LinkedList<Integer> l = new LinkedList<>();
        for (int index = d; index < expenditure.length ; index++) {
            double median  =  calcMedian(counterArray, d,  middleIndex,  odd);
            int expense = expenditure[index];
            if (expense >= 2*median) {
                alerts++;
                l.add(index);
            }

            counterArray[expenditure[index]]++;
            counterArray[expenditure[index - d]]--;
        }
        return alerts;

    }

    public static double calcMedian(int[] counterArray, int d, int middleIndex, boolean odd) {
        int counter = 0, left = 0;
        while (counter < middleIndex) {
            counter += counterArray[left++];
        }

        int right = left;
        left -= 1;

        if (counter > middleIndex || odd) return left;
        else {
            while (counterArray[right] == 0) right ++;
            return (left + right)/2d;
        }
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
