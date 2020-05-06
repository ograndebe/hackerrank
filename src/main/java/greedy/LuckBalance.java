package greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int totalLucky = 0;

        final ArrayList<Integer> importantContests = new ArrayList<>(contests.length);
        for (int i = 0 ; i < contests.length ; i++) {
            if (contests[i][1] == 0) totalLucky += contests[i][0];
            else importantContests.add(contests[i][0]);
        }

        Collections.sort(importantContests);
        int beginIndex = importantContests.size() - k;

        for (int i = 0 ; i < importantContests.size() ; i++) {
            if (i < beginIndex) totalLucky -= importantContests.get(i);
            else totalLucky += importantContests.get(i);
        }

        return totalLucky;

    }

    @Test
    public void sampleTest00 () {

        int[][] contests = {
                {5,1},
                {2,1},
                {1,1},
                {8,1},
                {10,0},
                {5,0},
        };
        int maxLucky = luckBalance(3, contests);

        assertEquals(29,maxLucky);

    }

}
