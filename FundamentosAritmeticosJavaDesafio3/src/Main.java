import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);

        int par = 0;
        int impar = 0;
        int pos = 0;
        int neg = 0;

        for (int i = 0; i < 5; i++) {

            int numero = leitor.nextInt();

            if (numero > 0){
                pos++;
            }
            if (numero % 2 == 0){
                par++;
            }
            if (numero % 2 == 1 || numero % 2 == -1){
                impar++;
            }
            if (numero < 0){
                neg++;
            }

        }

        System.out.println( par + " par(es)");
        System.out.println( impar + " impar(es)");
        System.out.println( pos + " positivo(s)");
        System.out.println( neg + " negativo(s)");
    }

}