import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Desafio1 {

    public static void main(String[] args) throws IOException {

        int entradas;
        int num;

        Scanner scanner = new Scanner(System.in);
        entradas = scanner.nextInt();

        List<Integer> numeros = new ArrayList<>();
        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();

        for (int i = 0; i < entradas; i++){
            num = scanner.nextInt();
            numeros.add(num);
        }

        for (int numero : numeros){
            if (numero % 2 == 0){
                par.add(numero);
            }
            else{
                impar.add(numero);
            }
        }

        numeros.clear();

        Collections.sort(par);
        Collections.sort(impar, Collections.reverseOrder());

        numeros = Stream.concat(par.stream(), impar.stream()).collect(Collectors.toList());

        for (int n: numeros){
            System.out.println(n);
        }

    }

}
