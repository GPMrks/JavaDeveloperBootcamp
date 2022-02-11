package InterfacesFuncionais;

import java.util.function.Predicate;

public class Predicados {

    public static void main(String[] args) {

        Predicate<String> estaVazio = String::isEmpty; // :: referencia, method isEmpty agindo diretamente sobre a String recebida, nenhuma modificação é feita.
//        Predicate<String> estaVazio = valor -> valor.isEmpty();
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Guilherme"));

    }

}
