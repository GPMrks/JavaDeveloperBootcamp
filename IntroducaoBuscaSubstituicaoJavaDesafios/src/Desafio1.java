import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Desafio1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testes = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testes; i++){

            List<String> entradas = new ArrayList<>(List.of(br.readLine().split(" ")));

            var palavras = entradas.stream().sorted().collect(Collectors.toList());

            var palavrasOrdenadas = palavras.stream()
                                            .sorted(Comparator.comparingInt(String::length).reversed()
                                            .thenComparing(String::compareTo)).collect(Collectors.joining(" "));

            System.out.println(palavrasOrdenadas);

        }


    }
}
