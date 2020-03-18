package strings;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagram {

    static int makeAnagram(String a, String b) {
        final HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0 ; i < a.length() ; i++) {
            letters.put(a.charAt(i),letters.getOrDefault(a.charAt(i),0)+1);
        }
        for (int i = 0 ; i < b.length() ; i++) {
            letters.put(b.charAt(i),letters.getOrDefault(b.charAt(i),0)-1);
        }

        int mustRemove = 0;
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() != 0) {
                mustRemove += Math.abs(entry.getValue());
            }
        }
        return mustRemove;

    }

}
