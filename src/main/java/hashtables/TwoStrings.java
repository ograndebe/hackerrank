package hashtables;

import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        final Set<String> chars1 = s1.chars().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.toSet());

        boolean contains = s2.chars().mapToObj(i -> String.valueOf((char) i))
                .anyMatch(ch->chars1.contains(ch));
        return contains?"YES":"NO";
    }

}
