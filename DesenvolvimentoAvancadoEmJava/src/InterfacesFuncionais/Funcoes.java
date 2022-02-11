package InterfacesFuncionais;

import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args) {

        Function<String, String> retornaNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();

        Function<String, Integer> converterStringParaInteiroEDobrar = texto -> Integer.valueOf(texto) * 2;

        System.out.println(retornaNomeAoContrario.apply("Guilherme"));

        System.out.println(converterStringParaInteiroEDobrar.apply("50"));

    }

}
