import java.io.IOException;
import java.util.Scanner;

public class Desafio3 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String senha;

        final String requeridos = "^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*)$";
        final String permitidos = "[a-zA-Z0-9]+";

        while (scanner.hasNextLine()) {
            senha = scanner.nextLine();

            if (senha.length() == 0 || senha.length() < 6 || senha.length() > 32 || !senha.matches(requeridos) || !senha.matches(permitidos) || senha.contains(" ")) { //complete o if de acordo com suas variaveis
                System.out.println("Senha invalida.");
            } else {
                System.out.println("Senha valida.");
            }

        }
    }
}
