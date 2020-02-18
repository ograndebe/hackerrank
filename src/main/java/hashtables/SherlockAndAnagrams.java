package hashtables;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<>(s.length()*s.length());

        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                final String currentSubString = s.substring(i,j);
                final String key = sort(currentSubString);
                int value = map.getOrDefault(key, 0);
                if (value > 0) {
                    totalCount += value;
                }
                map.put(key, ++value);
            }
        }

        return totalCount;
    }

    private static String sort(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Test
    public void example0() {

        final List<Integer> result = process("/hashtables/sherlockAndAnagrams/input00.txt");
        final List<Integer> output = getOutput("/hashtables/sherlockAndAnagrams/output00.txt");

        assertEquals(output, result);
    }

    @Test
    public void example1() {

        final List<Integer> result = process("/hashtables/sherlockAndAnagrams/input01.txt");
        final List<Integer> output = getOutput("/hashtables/sherlockAndAnagrams/output01.txt");

        assertEquals(output, result);
    }

    @Test
    public void example6() {

        final List<Integer> result = process("/hashtables/sherlockAndAnagrams/input06.txt");
        final List<Integer> output = getOutput("/hashtables/sherlockAndAnagrams/output06.txt");

        assertEquals(output, result);
    }



    private List<Integer> process(String resource){
        final Scanner scanner = new Scanner(SherlockAndAnagrams.class.getResourceAsStream(resource));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        LinkedList<Integer> resultList = new LinkedList<>();
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            resultList.add(result);
        }

        scanner.close();

        return resultList;
    }

    private List<Integer> getOutput(String resource){
        final Scanner scanner = new Scanner(SherlockAndAnagrams.class.getResourceAsStream(resource));

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

        return resultList;
    }



}
