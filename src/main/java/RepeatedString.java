public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        int singleCounter = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') singleCounter++;
        }

        long occurrencies = n/s.length();

        long tail = n%s.length();
        long tailOcurrencies = 0;
        for(int i = 0; i < tail; i++) {
            if(s.charAt(i) == 'a') tailOcurrencies++;
        }


        return occurrencies*singleCounter + tailOcurrencies;
    }

    public static void main (String[] args) {

        long r = repeatedString("aba",10);

        System.out.printf("Resultado %s",r);


    }


}
