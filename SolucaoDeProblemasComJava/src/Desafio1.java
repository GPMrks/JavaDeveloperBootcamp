import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Desafio1 {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int valores = scr.nextInt();
        Map<Integer, Integer> numeros = new HashMap<>();

        int numero = 0;

        int vezes = 0;

        for (int i = 0; i < valores; i++) {
            numero = scr.nextInt();

            if (numeros.containsKey(numero)) {
                vezes = numeros.get(numero);
                numeros.put(numero, vezes++);

            } else {
                vezes = 1;
                numeros.put(numero, vezes);
            }

            numeros.put(numero, vezes);
        }

        numeros.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " aparece " + e.getValue() + " vez(es)"));
    }
}