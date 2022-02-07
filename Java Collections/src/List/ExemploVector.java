package List;

import java.util.List;
import java.util.Vector;

public class ExemploVector {

    public static void main(String[] args) {

        List<String> esportes = new Vector<>();

        esportes.add("Futebol");
        esportes.add("Basquete");
        esportes.add("Volei");
        esportes.add("Handebol");

        System.out.println(esportes);

        esportes.set(3, "Futsal");

        esportes.remove(1);

        System.out.println(esportes);

        for (String esp: esportes){
            System.out.println("----> " + esp);
        }

    }

}
