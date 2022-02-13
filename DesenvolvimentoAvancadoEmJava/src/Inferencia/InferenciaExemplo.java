package Inferencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciaExemplo {

    public static void main(String[] args) throws IOException {

//        System.out.println(printNome("Guilherme", "Marques"));
//        System.out.println("A soma é: " + printSoma(5, 5, 10, 15.45, 3.15, 40));

        connectAndPrint();

    }

    private static void connectAndPrint() throws IOException {

        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();

        try(var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {

            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String printNome(String nome, String sobrenome){
        var nomeCompleto = nome + " " + sobrenome;
        return nomeCompleto;
    }

    public static double printSoma(double... numeros){
        double soma = 0;
        if (numeros.length > 0){
            for (var numero : numeros){
                soma += numero;
            }
        }
        return soma;
    }

}
