package Map;

import java.util.HashMap;
import java.util.Map;

public class ExemploHashMap {

    public static void main(String[] args) {

        Map<String, Integer> campeoesMundialFifa = new HashMap<>();

        campeoesMundialFifa.put("Brasil", 5);
        campeoesMundialFifa.put("Alemanha", 4);
        campeoesMundialFifa.put("Italia", 4);
        campeoesMundialFifa.put("Uruguai", 2);
        campeoesMundialFifa.put("Argentina", 2);
        campeoesMundialFifa.put("Franca", 2);
        campeoesMundialFifa.put("Inglaterra", 1);
        campeoesMundialFifa.put("Espanha", 1);

        System.out.println(campeoesMundialFifa);

        campeoesMundialFifa.put("Brasil", 6);

        System.out.println(campeoesMundialFifa);

        System.out.println(campeoesMundialFifa.get("Argentina"));

        System.out.println(campeoesMundialFifa.containsKey("Franca"));

        campeoesMundialFifa.remove("Franca");

        System.out.println(campeoesMundialFifa.containsKey("Franca"));

        System.out.println(campeoesMundialFifa.containsValue(6));

        System.out.println(campeoesMundialFifa.size());

        System.out.println(campeoesMundialFifa);

        for (Map.Entry<String, Integer> entry: campeoesMundialFifa.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

        for (String key: campeoesMundialFifa.keySet()){
            System.out.println(key + " -- " + campeoesMundialFifa.get(key));
        }

        System.out.println(campeoesMundialFifa);

        System.out.println(campeoesMundialFifa.containsKey("Estados Unidos"));

        System.out.println(campeoesMundialFifa.containsValue(5));

        System.out.println(campeoesMundialFifa.size());

        campeoesMundialFifa.clear();

        System.out.println(campeoesMundialFifa.size());

    }

}
