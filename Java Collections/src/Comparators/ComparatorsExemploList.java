package Comparators;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorsExemploList {

    public static void main(String[] args) {

        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("Joao", 18));
        estudantes.add(new Estudante("Thiago", 20));
        estudantes.add(new Estudante("George", 22));
        estudantes.add(new Estudante("Larissa", 21));

        System.out.println("--- Orgem de Insercao ---");
        System.out.println(estudantes);

        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());

        System.out.println("\n\n--- Ordem Natural dos Numeros - Idade ---");
        System.out.println(estudantes);

        estudantes.sort((first, second) -> second.getIdade() - first.getIdade());

        System.out.println("\n\n--- Ordem Reversa dos Numeros - Idade ---");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));

        System.out.println("\n\n--- Ordem Natural dos Numeros - Idade (Method reference) ---");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());

        System.out.println("\n\n--- Ordem Reversa dos Numeros - Idade (Method Reference) ---");
        System.out.println(estudantes);

        Collections.sort(estudantes);

        System.out.println("\n\n--- Ordem Natural dos Numeros - Idade (Interface Comparable) ---");
        System.out.println(estudantes);

        Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());

        System.out.println("\n\n--- Ordem Reversa dos Numeros - Idade (Interface Comparator)");
        System.out.println(estudantes);

    }
}
