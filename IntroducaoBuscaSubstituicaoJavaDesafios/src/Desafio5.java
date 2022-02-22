import java.util.Scanner;

public class Desafio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String linha;

        while(scanner.hasNextLine()) {
            linha = scanner.nextLine();
            boolean inicio = true;


            while (linha.contains("_") || linha.contains("*")) {
                if (linha.contains("_") && inicio){
                    linha = linha.replaceFirst("_", "<i>");
                    inicio = false;
                }
                else if (linha.contains("_") && !inicio){
                    linha = linha.replaceFirst("_", "</i>");
                    inicio = true;
                }
                else if (linha.contains("*") && inicio){
                    linha = linha.replaceFirst("\\*", "<b>");
                    inicio = false;
                }
                else if (linha.contains("*") && !inicio){
                    linha = linha.replaceFirst("\\*", "</b>");
                    inicio = true;
                }
            }

            System.out.println(linha);

        }
    }
}
