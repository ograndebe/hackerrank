package sorting;

import java.util.Arrays;

public class MaximumToys {

    static int maximumToys(int[] prices, int k) {
        final int[] orderedPrices = Arrays.stream(prices).sorted().toArray();

        int toyCounter = 0;
        for (int price : orderedPrices) {
            if (price < k) {
                toyCounter++;
                k -= price;
            }
        }

        return toyCounter;
    }


}
