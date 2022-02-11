package InterfacesFuncionais;

public class FuncaoAltaOrdem {

    public static void main(String[] args) {

        Calcular soma = (a, b) -> a + b;
        Calcular subtracao = (a, b) -> a - b;
        Calcular multi = (a, b) -> a * b;
        Calcular divisao = (a, b) -> a / b;

        System.out.println(executarOperacao(soma, 20, 5));
        System.out.println(executarOperacao(subtracao, 20, 5));
        System.out.println(executarOperacao(multi, 20, 5));
        System.out.println(executarOperacao(divisao, 20, 5));

    }

    public static int executarOperacao(Calcular op, int a, int b){
        return op.operacao(a, b);
    }

}

@FunctionalInterface
interface Calcular{
    public int operacao(int a, int b);
}
