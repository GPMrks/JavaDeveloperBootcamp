package ParadigmaFuncional;

import static ParadigmaFuncional.RecursividadeFatorial.fatorial;

public class RecursividadeFatorialLambda {

    public static void main(String[] args) {

        FatorialLambda fat = value -> {
            if (value == 1){
                return value;
            }
            else{
                return value * fatorial(value -1);
            }
        };

        System.out.println(fat.fatorial(5));

    }

}
