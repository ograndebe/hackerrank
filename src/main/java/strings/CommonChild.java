package strings;

import org.junit.jupiter.api.Test;
import util.MyUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonChild {

    static int commonChildResursive(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        } else {
            final char last1 = s1.charAt(s1.length() - 1);
            final char last2 = s2.charAt(s2.length() - 1);
            if (last1 == last2) {
                return 1 + commonChild(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
            } else {
                return Math.max(
                        commonChild(s1.substring(0,s1.length()-1),s2),
                        commonChild(s1,s2.substring(0,s2.length()-1))
                        );
            }
        }

    }

    static int commonChild(String s1, String s2) {
        int[][] buffer = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length() ; i++) {
            for (int j = 0; j <= s2.length() ; j++) {
                if (i == 0 || j == 0) buffer[i][j] = 0;
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    buffer[i][j] = buffer[i-1][j-1]+1;
                } else {
                    buffer[i][j] = Math.max(buffer[i-1][j], buffer[i][j-1]);
                }
            }
        }

        return buffer[s1.length()][s2.length()];
    }


    @Test
    public void enunciado() {
        int actual = commonChild("ABCD", "ABDC"); //ABC  OR ABD
        /*
         * ABCD
         *
         * ABDC
         *
         * */

        assertEquals(3, actual);
    }

    @Test
    public void example00() {
        int actual = commonChild("HARRY", "SALLY"); // AY
        assertEquals(2, actual);
    }

    @Test
    public void example01() {
        int actual = commonChild("AA", "BB");
        assertEquals(0, actual);
    }

    @Test
    public void example02() {
        int actual = commonChild("SHINCHAN", "NOHARAAA"); //NHA
        assertEquals(3, actual);

        /*
        SHINCHAN -> HNHAN
         . . ...
        NOHARAAA -> NHAAAA
        . .. ...

        NHA
        * */
    }

    @Test
    public void example03() {
        int actual = commonChild("ABCDEF", "FBDAMN"); //BD

        /*
         * ABCDEF -> ABDF
         * .. . .
         * FBDAMN -> FBDA
         * ....
         * */
        assertEquals(2, actual);
    }
}
