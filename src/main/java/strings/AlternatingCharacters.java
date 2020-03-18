package strings;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int deletions = 0;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (last == c ) {
                deletions++;
            }

            last = c;

        }
        return deletions;
    }


}
