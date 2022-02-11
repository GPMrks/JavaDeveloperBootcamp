package ParadigmaFuncional;

public class FuncaoComClasseAnonima {

    public static void main(String[] args) {

        Funcao prefixoSenhor = new Funcao() {
            @Override
            public String gerar(String nome) {
                return "Sr. " + nome;
            }
        };

        System.out.println(prefixoSenhor.gerar("João"));

    }

}
