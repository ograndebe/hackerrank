import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {


    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int current = 0;
        int valleyCounter = 0;
        for (int i = 0; i < n; i++) {

            final char c = s.charAt(i);
            int toAdd = c == 'D'?-1:1;
            current += toAdd;

            if (current == 0 && toAdd == 1)  valleyCounter++;

        }
        return valleyCounter;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
