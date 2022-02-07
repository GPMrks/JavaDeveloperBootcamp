package List;

import java.util.*;

public class ExemploList {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Juliana");
        nomes.add("Anderson");
        nomes.add("Bruna");
        nomes.add("Marcelo");

        System.out.println(nomes);

        nomes.set(2, "Douglas");

        Collections.sort(nomes);

        System.out.println(nomes);

        nomes.remove(4);

        System.out.println(nomes);

        nomes.remove("Bruna");

        System.out.println(nomes);

        String nome = nomes.get(1);

        System.out.println(nome);

        int tamanho = nomes.size();

        System.out.println(tamanho);

        nomes.remove("Carlos");

        System.out.println(nomes.size());

        boolean temAnderson = nomes.contains("Anderson");

        System.out.println(temAnderson);

        System.out.println(nomes.contains("Fernando"));

        System.out.println(nomes.isEmpty());

        for (String nomeDoItem: nomes){
            System.out.println("-------> " + nomeDoItem);
        }

        Iterator<String> iterator = nomes.iterator();

        while (iterator.hasNext()){
            System.out.println("-------> " + iterator.next());
        }

        nomes.clear();

        System.out.println(nomes.isEmpty());

    }

}
