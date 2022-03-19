import java.io.IOException;
import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) throws IOException {
        Scanner scr = new Scanner(System.in);
        String vowel;
        String sentence;
        int count;

        while (scr.hasNext()) {

            count = 0;
            vowel = scr.nextLine();
            sentence = scr.nextLine();

            for (int i = 0; i < vowel.length(); i++) {
                for (int j = 0; j < sentence.length(); j++) {
                    if (sentence.charAt(j) == vowel.charAt(i)) {
                        count++;
                    }
                }

            }
            System.out.println(count);
        }
    }
}
