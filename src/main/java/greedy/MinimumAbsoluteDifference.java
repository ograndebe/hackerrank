package greedy;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1 ; i < arr.length ; i++ ){
            int abs = Math.abs(arr[i-1]-arr[i]);
            if (abs < min) min = abs;
        }
        return min;
    }

}
