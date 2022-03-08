package JDBC;

import java.util.List;

public class QueriesExecution {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        // ====================== 1 - Consulta ======================

        List<Aluno> alunos = alunoDAO.list();

//        alunos.stream().forEach(System.out::println);

        // ====================== 1.1 - Consulta com filtro ======================

        Aluno alunoParaConsulta = alunoDAO.getById(2);

        //System.out.println(alunoParaConsulta);

        // ====================== 2- Inserção ======================

//        Aluno alunoParaInserir = new Aluno(
//                "Guilherme",
//                27,
//                "MG"
//        );

        //alunoDAO.create(alunoParaInserir);

        // ====================== 3- Delete ======================
//        alunoDAO.list().stream().forEach(System.out::println);
//
//        alunoDAO.delete(9);
//
//        alunoDAO.list().stream().forEach(System.out::println);

        // ====================== 4- Update ======================
        alunoDAO.list().stream().forEach(System.out::println);

        Aluno alunoParaAtualizar = alunoDAO.getById(10);
        alunoParaAtualizar.setNome("Joaquim");
        alunoParaAtualizar.setIdade(1);
        alunoParaAtualizar.setEstado("MG");

        alunoDAO.update(alunoParaAtualizar);

        alunoDAO.list().stream().forEach(System.out::println);


    }

}
