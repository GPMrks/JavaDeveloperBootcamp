import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int qtdPalavras = Integer.parseInt(br.readLine());


        while (qtdPalavras != 0) {

            List<String> conjunto = new ArrayList<>();

            for (int i = 0; i < qtdPalavras; i++) {
                conjunto.add(br.readLine());
            }

            conjunto = conjunto.stream().sorted().collect(Collectors.toList());
            String saida = "Conjunto Bom";

            for (int i = 0; i < qtdPalavras - 1; i++) {
                if (conjunto.get(i + 1).startsWith(conjunto.get(i))) {
                    saida = "Conjunto Ruim";
                }
            }

            System.out.println(saida);
            qtdPalavras = Integer.valueOf(br.readLine());

        }

    }

}
