package Classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String sigla;

    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Aluno> alunos = new ArrayList<>();

    public Estado(){}

    public Estado(String nome, String sigla){
        this.nome = nome;
        this.sigla = sigla;
    }

    public Estado(String nome, String sigla, List<Aluno> alunos){
        this.nome = nome;
        this.sigla = sigla;
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", alunos=" + alunos +
                '}';
    }

}
