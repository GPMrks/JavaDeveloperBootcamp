package InterfacesFuncionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {

        String[] nomes = {"Guilherme", "Pereira", "Marques", "Java", "Developer"};
        Integer[] numeros = {1, 2, 3, 4, 5};

//        imprimirNomesFiltrados(nomes);
        imprimirTodosOsNomes(nomes);
//        imprimirODobroDeCadaItem(numeros);

        String guilherme = Stream.of(nomes)
                .filter(nome -> nome.equals("Guilherme"))
                .collect(Collectors.joining());

//        System.out.println(guilherme);

        Stream.of(nomes)
                .forEach(nome -> System.out.println("Impresso pelo forEach: " + nome)); //referencia System.out::println

        Stream.of(numeros)
                .map(numero -> numero * 2)
                .forEach(System.out::println);

        //Outra forma de se utilizar o Stream, como visto no curso Implementação de Collections e Stream em Java
        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de Projeto");
        profissoes.add("Gerente de Qualidade");

        profissoes.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);

    }

    public static void imprimirNomesFiltrados(String... nomes){

        String nomesParaImprimir = "";

        for (int i = 0; i < nomes.length; i++){
            if (nomes[i].equals("Guilherme")){
                nomesParaImprimir += " " + nomes[i];
            }
        }
        System.out.println(nomesParaImprimir);
    }

    public static void imprimirTodosOsNomes(String... nomes){
        for (String nome : nomes){
            System.out.println("Impresso pelo for: " + nome);
        }
        System.out.println();
    }

    public static void imprimirODobroDeCadaItem(Integer... numeros){
        for (Integer numero : numeros){
            System.out.println(numero * 2);
        }
    }

}
