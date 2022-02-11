package ParadigmaFuncional;

import java.util.Arrays;
import java.util.Date;

public class ComposicaoDeFuncoes {

    public static void main(String[] args) {

        long then = System.currentTimeMillis();

        //funcional
        int[] valores = {1, 2, 3, 4};
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(numero -> System.out.println(numero));

        //imperativo
        for (int i = 0; i < valores.length; i++){
            int valor = 0;
            if(valores[i] % 2 == 0){
                valor = valores[i] * 2;
                if(valor != 0){
                    System.out.println(valor);
                }
            }
        }

        long now = System.currentTimeMillis();
        System.out.println(now - then);

    }

}
