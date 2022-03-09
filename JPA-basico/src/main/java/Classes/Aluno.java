package Classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private int idade;

    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;

    public Aluno() {}

    public Aluno (String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno (String nome, int idade, Estado estado){
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", estado=" + estado +
                '}';
    }

}
