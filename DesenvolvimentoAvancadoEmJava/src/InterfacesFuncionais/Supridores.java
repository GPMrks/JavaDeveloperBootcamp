package InterfacesFuncionais;

import java.util.function.Supplier;

public class Supridores {

    public static void main(String[] args) {

        Supplier<Pessoa> instanciaPessoa = () -> new Pessoa(); // referencia Pessoa::new;

        System.out.println(instanciaPessoa.get());

    }

}

class Pessoa{
    private String nome;
    private Integer idade;

    public Pessoa(){
        nome = "Guilherme";
        idade = 27;
    }

    @Override
    public String toString(){
        return String.format("nome: %s\nidade: %d anos", nome, idade);
    }

}
