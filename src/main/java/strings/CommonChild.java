package strings;

import org.junit.jupiter.api.Test;
import util.MyUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonChild {

    static int commonChild(String s1, String s2) {
        int[][] matrix = new int[8][8];

        int lowerI = 5000;
        int lowerJ = 5000;
        int totalCommon = 0;
        for(int i = 0; i < s1.length() ; i++) {
            for(int j = 0; j < s2.length() ; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    matrix[i][j] = 1;
                    totalCommon++;
                    if (i < lowerI) lowerI = i;
                    if (j < lowerJ) lowerJ = j;
                }
            }
        }
        System.out.printf("li>%s, lj>%s\n",lowerI, lowerJ);
        System.out.println("Antes");
        MyUtils.printMatrix(matrix);
        if (totalCommon == 0 ) return 0;

        int sizePath1 = 0;
        int jStart = lowerJ;
        for(int i = lowerI; i < s1.length() ; i++) {
            for (int j = jStart; j < s2.length(); j++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j]++;
                    jStart = j+1;
                    sizePath1++;
                    break;
                }
            }
        }
        System.out.println("passo 1");
        MyUtils.printMatrix(matrix);

        int sizePath2 = 0;
        int iStart = lowerI;
        for(int j = lowerJ; j < s2.length() ; j++) {
            for (int i = iStart; i < s1.length(); i++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j]++;
                    iStart = i+1;
                    sizePath2++;
                    break;
                }
            }
        }
        System.out.println("passo 2");
        MyUtils.printMatrix(matrix);

        return Math.max(sizePath1, sizePath2);
    }


    @Test
    public void enunciado() {
        int actual = commonChild("ABCD","ABDC"); //ABC  OR ABD
        /*
        * ABCD
        *
        * ABDC
        *
        * */

        assertEquals(3,actual);
    }
    @Test
    public void example00() {
        int actual = commonChild("HARRY","SALLY"); // AY
        assertEquals(2,actual);
    }
    @Test
    public void example01() {
        int actual = commonChild("AA","BB");
        assertEquals(0,actual);
    }
    @Test
    public void example02() {
        int actual = commonChild("SHINCHAN","NOHARAAA"); //NHA
        assertEquals(3,actual);

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
        int actual = commonChild("ABCDEF","FBDAMN"); //BD

        /*
        * ABCDEF -> ABDF
        * .. . .
        * FBDAMN -> FBDA
        * ....
        * */
        assertEquals(2,actual);
    }
}
