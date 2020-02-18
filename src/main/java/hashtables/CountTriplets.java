package hashtables;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountTriplets {

    static long countTripletsOld(List<Long> arr, long r) {
        System.out.println(arr);
        System.out.println(r);
        final Map<Long, Long> map = arr.stream().collect(Collectors.groupingBy(i->i, Collectors.counting()));
        long tripplets = 0;

        final Set<Map.Entry<Long, Long>> entries = map.entrySet();
        for (Map.Entry<Long, Long> entry : entries) {
            long el1 = entry.getKey();
            long el2 = el1*r;
            long el3 = el2*r;
            long el1Apparences = entry.getValue();
            long el2Apparences = map.getOrDefault(el2,0L);
            long el3Apparences = map.getOrDefault(el3,0L);

            System.out.printf("%s,%s,%s -> %s,%s,%s\n", el1, el2, el3, el1Apparences, el2Apparences, el3Apparences);

            long trippletsFound = el1Apparences*el2Apparences*el3Apparences;
            tripplets += trippletsFound;
        }

        return tripplets;
    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        System.out.println(arr);
        System.out.println(r);

        final HashMap<Long, Long> rightMap = new HashMap<>();
        final HashMap<Long, Long> acumulatorMap = new HashMap<>();
        long tripplets = 0;

        for (int i = arr.size() -1 ; i >= 0 ; i--) {
            long element = arr.get(i);
            long rightElement = element*r;

            if (acumulatorMap.containsKey(rightElement)) {
                tripplets += acumulatorMap.get(rightElement);
            }

            acumulatorMap.put(element, acumulatorMap.getOrDefault(element,0L)+ rightMap.getOrDefault(rightElement,0L) );

            rightMap.put(element, rightMap.getOrDefault(element,0L)+1L);
            System.out.println("#################");
            System.out.println(rightMap);
            System.out.println("#################");
            System.out.println(acumulatorMap);
            System.out.println("#################\n\n");
        }

        return tripplets;
    }



    @Test
    public void testAdicional() throws IOException {
        final long result = countTriplets(Arrays.asList(1L,2L,1L,2L,4L),2L);
        final long output = 3;
        assertEquals(output,result);
    }

    @Test
    public void test00() throws IOException {
        final long result = callInput("/hashtables/countTriplets/input00.txt");
        final long output = getOutput("/hashtables/countTriplets/output00.txt");
        assertEquals(output,result);
    }


    @Test
    public void test01() throws IOException {
        final long result = callInput("/hashtables/countTriplets/input01.txt");
        final long output = getOutput("/hashtables/countTriplets/output01.txt");
        assertEquals(output,result);
    }


    @Test
    public void test02() throws IOException {
        final long result = callInput("/hashtables/countTriplets/input02.txt");
        final long output = getOutput("/hashtables/countTriplets/output02.txt");
        assertEquals(output,result);
    }

    @Test
    public void test12() throws IOException {
        final long result = callInput("/hashtables/countTriplets/input12.txt");
        final long output = getOutput("/hashtables/countTriplets/output12.txt");
        assertEquals(output,result);
    }


    private static long getOutput(String resource) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(CountTriplets.class.getResourceAsStream(resource)));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        bufferedReader.close();
        return n;
    }


    public static long callInput(String resource) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(CountTriplets.class.getResourceAsStream(resource)));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);


        bufferedReader.close();


        return ans;
    }

}
