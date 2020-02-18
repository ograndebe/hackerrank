package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Hourglass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int biggest = -9*7-1;
        for (int x =0 ; x < arr.length-2 ; x++) {
            System.out.println(Arrays.stream(arr[x]).boxed().collect(Collectors.toList()));
            for (int y = 0; y < arr[x].length -2 ; y++) {
                int currentSum = calculateSum(arr, x, y);
                System.out.printf("Result : %s,%s= %s\n",x,y,currentSum);
                biggest = Math.max(currentSum, biggest);
            }
        }
        return biggest;
    }

    static int calculateSum(int[][] arr, int x, int y) {
        return  arr[y][x]+ arr[y][x+1] + arr[y][x+2]+
                          arr[y+1][x+1]+
                arr[y+2][x]+ arr[y+2][x+1] + arr[y+2][x+2];
    }


    public static void main (String[] args) {
        int arr [][] = {
                {1 ,1 ,1 ,0 ,0 ,0},
                {0 ,1 ,0 ,0 ,0 ,0},
                {1 ,1 ,1 ,0 ,0 ,0},
                {0 ,0 ,2 ,4 ,4 ,0},
                {0 ,0 ,0 ,2 ,0 ,0},
                {0 ,0 ,1 ,2 ,4 ,0}
        };

        int sum = hourglassSum(arr);
        System.out.printf("Resultado: %s", sum);
        //19

    }


}
