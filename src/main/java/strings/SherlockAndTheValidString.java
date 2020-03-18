package strings;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockAndTheValidString {

    static String isValid(String s) {

        final HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            final Integer freq = map.getOrDefault(c, 0);
            final int newFreq = freq + 1;
            map.put(c, newFreq);
        }

        final HashMap<Integer, Integer> freqMap = new HashMap<>(map.values().size());
        for (Integer freq : map.values()) {
            freqMap.put(freq,freqMap.getOrDefault(freq,0)+1);
        }

        if (freqMap.size() >2) return "NO";
        if (freqMap.size() == 1) return "YES";

        final ArrayList<Map.Entry<Integer, Integer>> result = new ArrayList<>(freqMap.entrySet());
        Map.Entry<Integer,Integer> bigger, smaller;
        if (result.get(0).getValue() > result.get(1).getValue()) {
            bigger = result.get(0);
            smaller = result.get(1);
        } else {
            bigger = result.get(1);
            smaller = result.get(0);
        }

        if (Math.abs(smaller.getKey()-bigger.getKey())==1 && smaller.getValue() == 1) return "YES";
        if (smaller.getKey() == 1 && smaller.getValue() == 1) return "YES";
        return "NO";
    }


    @Test
    public void testCase1() {
        final String result = isValid("aabbccddeefghi");
        assertEquals("NO", result);
    }

    @Test
    public void testCase2() {
        final String result = isValid("abcdefghhgfedecba");
        assertEquals("YES", result);
    }
    @Test
    public void testCase4() {
        final String result = isValid("aabbc");
        assertEquals("YES", result);
    }

    @Test
    public void testCase13() {
        final Scanner scanner = new Scanner(SherlockAndTheValidString.class.getResourceAsStream("/strings/sherlock/input13.txt"));
        String input = scanner.nextLine();
        final String result = isValid(input);
        assertEquals("YES", result);
    }
}
