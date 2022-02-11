package ParadigmaFuncional;

public class FuncaoComLambda {

    public static void main(String[] args) {

        Funcao prefixoSenhor = nome -> { return "Sr. " + nome; };

        System.out.println(prefixoSenhor.gerar("João"));

    }

}
