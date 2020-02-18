package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int [] ret = new int[a.length];
        for (int i = 0 ; i < a.length ; i++) {
            int newIndex = i-d;
            if (newIndex < 0) newIndex = a.length +newIndex ;
            ret[newIndex] = a[i];
        }
        return ret;
    }

    public static void main (String[] args) {
        int[] arr = {33 ,47 ,70 ,37 ,8 ,53 ,13 ,93 ,71 ,72 ,51, 100, 60, 87 ,97};

        int[] result = rotLeft(arr,13);

        //87 97 33 47 70 37 8 53 13 93 71 72 51 100 60
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

}
