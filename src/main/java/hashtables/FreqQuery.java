package hashtables;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreqQuery {

    static List<Integer> freqQuery(int[][] queries) {

        LinkedList<Integer> result = new LinkedList<>();
        TreeMap<Integer, Integer> counterMap = new TreeMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i <queries.length ; i++) {
            final Integer operation = queries[i][0];
            final Integer dataElement =  queries[i][1];
//            System.out.println(query);
            if (operation == 1 || operation == 2) {
                Integer toAdd = operation == 1?1:-1;
                Integer newFreq = counterMap.getOrDefault(dataElement,0)+toAdd;
                if (newFreq > 0) counterMap.put(dataElement, newFreq);
                else counterMap.remove(dataElement);
                freqMap.put(newFreq, freqMap.getOrDefault(newFreq,0)+1);
                Integer newFreqTimes = freqMap.getOrDefault(newFreq-toAdd,0)-1;
                if (newFreqTimes > 0) freqMap.put(newFreq-toAdd, newFreqTimes);
                else freqMap.remove(newFreq-toAdd);
            } else {
                Integer freq = freqMap.getOrDefault(dataElement,0);
                if (freq > 0 )result.add(1);
                else result.add(0);
            }
//            System.out.printf("%s   %s\n",counterMap, result);
        }

        return result;
    }




    @Test
    public void test00() throws IOException {
        final List<Integer> p = testResource("/hashtables/freqQuery/input00.txt");
        final List<Integer> output = getOutput("/hashtables/freqQuery/output00.txt");
        assertEquals(output,p);
    }

    @Test
    public void test01() throws IOException {
        final List<Integer> p = testResource("/hashtables/freqQuery/input01.txt");
        final List<Integer> output = getOutput("/hashtables/freqQuery/output01.txt");
        assertEquals(output,p);
    }

    @Test
    public void test14() throws IOException {
        final List<Integer> p = testResource("/hashtables/freqQuery/input14.txt");
        final List<Integer> output = getOutput("/hashtables/freqQuery/output14.txt");
        assertEquals(output,p);
    }


    public static List<Integer> testResource(String resource) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(FreqQuery.class.getResourceAsStream(resource)))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            List<Integer> ans = freqQuery(queries);

            return ans;
        }
    }


    private List<Integer> getOutput(String resource){
        final Scanner scanner = new Scanner(FreqQuery.class.getResourceAsStream(resource));

        LinkedList<Integer> resultList = new LinkedList<>();
        boolean ok = true;
        do {
            try {
                int q = scanner.nextInt();
                resultList.add(new Integer(q));
            } catch (NoSuchElementException e) {
                ok = false;
            }
        } while(ok);

        scanner.close();

        return resultList;
    }


}
