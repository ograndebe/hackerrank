package hashtables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckMagazine {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        final HashMap<String, Integer> magazineMap = new HashMap<>(magazine.length);
        for (String word: magazine) {
            Integer amount = 0;
            if (magazineMap.containsKey(word)) {
                amount = magazineMap.get(word);
            }
            magazineMap.put(word, ++amount);
        }

        if (Arrays.stream(note).allMatch(word->{
            if (magazineMap.containsKey(word)) {
                final Integer amount = magazineMap.get(word);
                if (amount > 0) {
                    magazineMap.put(word, amount-1);
                    return true;
                }
            }
            return false;
        })) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    @Test
    public void sample0 (){
        final String[] magazine = "give me one grand today night".split("[ ]");
        final String[] note = "give one grand today".split("[ ]");

        checkMagazine(magazine, note);
        assertEquals("Yes", outContent.toString().trim());
    }

    @Test
    public void sample1 (){
        final String[] magazine = "two times three is not four".split("[ ]");
        final String[] note = "two times two is four".split("[ ]");

        checkMagazine(magazine, note);
        assertEquals("No", outContent.toString().trim());
    }
    @Test
    public void sample2 (){
        final String[] magazine = "ive got a lovely bunch of coconuts".split("[ ]");
        final String[] note = "ive got some coconuts".split("[ ]");

        checkMagazine(magazine, note);
        assertEquals("No", outContent.toString().trim());
    }
}
