package ProcessamentoAssincronoEParalelo;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {

//        long inicio = System.currentTimeMillis();
//        IntStream.range(1, 100000).forEach(num -> fatorial(num));//Serial Streams
//        long fim = System.currentTimeMillis();
//        System.out.println("Tempo de Execução Serial :: " + (fim - inicio));
//
//        inicio = System.currentTimeMillis();
//        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));//Parallel Streams
//        fim = System.currentTimeMillis();
//        System.out.println("Tempo de Execução Parallel :: " + (fim - inicio));

        List<String> nomes = Arrays.asList("Guilherme", "Pereira", "Marques");
        nomes.parallelStream().forEach(System.out::println);

    }

    public static long fatorial(long num){
        long fat = 1;

        for(long i = 2; i <= num; i++){
            fat *= i;
        }
        return fat;
    }

}
