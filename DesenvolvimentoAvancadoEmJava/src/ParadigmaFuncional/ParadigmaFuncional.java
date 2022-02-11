package ParadigmaFuncional;

import java.util.function.UnaryOperator;

public class ParadigmaFuncional {

    public static void main(String[] args) {

        UnaryOperator<Integer> calcularValorVezesTres = valor -> valor * 3; // um conceito do paradigma funcional, a ação não é executada no momento;

        int valor = 0;

        System.out.println("O resultado é: " + calcularValorVezesTres.apply(50));

    }

}
