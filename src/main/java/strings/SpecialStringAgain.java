package strings;

import hashtables.FreqQuery;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialStringAgain {


    static boolean isSpecial(String sub) {
        char first = sub.charAt(0);
        System.out.println(sub);
        int middleIndex = sub.length()%2!=0?sub.length()/2:-1;
        for (int i = 1 ; i < sub.length(); i++) {
            if (i != middleIndex && first != sub.charAt(i)) return false;
        }
        return true;
    }
    static long substrCount(int n, String s) {
        int special = 0;
        for (int i = 0 ; i < n; i++) {
            char first = s.charAt(i);
            int oddIndex = -1;
            for (int j = i ; j < n; j++) {
                int length = j-i+1;
//                System.out.printf("i: %s\t j: %s\t len: %s\t sub: %s\t\t\t fst: %s\t lst: %s\t mi: %s\t odd: %s\t sp: %s\n",
//                        i, j, length, s.substring(i,j+1), first, s.charAt(j), middleIndex, oddIndex, special);
                if (length == 1) special++;
                else {
                    int middleIndex = length%2!=0? length/2+i:-1;
                    char last = s.charAt(j);
                    if (first != last) {
                        if (oddIndex == -1) {
                            oddIndex = j;
                        } else {
                            break;
                        }
                    } else {
                        if (oddIndex == -1) special++;
                        else {
                            if (middleIndex == oddIndex) special++;
                        }
                    }
                }
            }
        }
        return special;
    }


    @Test
    public void test00() {
        test("00");
    }
    @Test
    public void test01() {
        test("01");
    }
    @Test
    public void test02() {
        test("02");
    }

    @Test
    public void test16() {
        test("16");
    }

    private void test(String testId) {
        final long actual = testCase(testId);
        assertEquals(getOutput(testId), actual);
    }


    private static long testCase(String inputFile) {
        final Scanner scanner = new Scanner(SpecialStringAgain.class.getResourceAsStream("/strings/specialstringagain/input"+inputFile+".txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        scanner.close();
        return result;
    }

    private Long getOutput(String example){
        final Scanner scanner = new Scanner(FreqQuery.class.getResourceAsStream(String.format("/strings/specialstringagain/output%s.txt", example)));

        Long result  = null;
        boolean ok = true;
        do {
            try {
                result = scanner.nextLong();
            } catch (NoSuchElementException e) {
                ok = false;
            }
        } while(ok);

        scanner.close();

        return result;
    }
}
