package ParadigmaFuncional;

public class TailCallFatorial {

    public static void main(String[] args) {

        System.out.println(fatorialA(5));

    }

    public static double fatorialA(double valor){
        return fatorialTailCall(valor, 1);
    }

    public static double fatorialTailCall(double valor, double numero){
        if(valor == 0){
            return numero;
        }
        return fatorialTailCall(valor - 1, numero * valor);
    }

}
