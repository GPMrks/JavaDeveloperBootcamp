import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Desafio2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int qtdListas = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> listaDeCompras = new LinkedHashSet<>();

        for (int i = 0; i < qtdListas; i++) {
            LinkedHashSet<String> separa = new LinkedHashSet<>(List.of(br.readLine().split(" ")));
            var itens = separa.stream().sorted().collect(Collectors.joining(" "));

            listaDeCompras.add(itens);
        }
        listaDeCompras.forEach(System.out::println);
    }
}