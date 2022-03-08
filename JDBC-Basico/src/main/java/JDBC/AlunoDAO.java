package JDBC;

//DAO = Data Access Object - Responsável pelo acesso ao banco

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // 1- Consulta
    public List<Aluno> list(){
        //Preparar lista que irá retornar alunos após consultar o BD;

        List<Aluno> listaAlunos = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()){

            PreparedStatement prst = conn.prepareStatement("SELECT id, nome, idade, estado FROM aluno;");

            ResultSet rs = prst.executeQuery();

            while(rs.next()){

                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("estado")
                );

                listaAlunos.add(aluno);
            }

        } catch (Exception e) {

        }

        return listaAlunos;
    }

    //1.1- Consulta com filtro
    public Aluno getById(int id){
        //Preparar objeto aluno para receber os valores do banco de dados.
        Aluno aluno = new Aluno();

        try(Connection conn = ConnectionFactory.getConnection()){

            //Preparar consulta SQL
            String sql = "SELECT * FROM aluno WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Guarda valores retornados da tabela aluno no objeto aluno.
            if (rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e){
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }
        return aluno;
    }

    // 2- Inserção
    public void create(@NotNull Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()){

            //Preparar SQL para inserção de dados do aluno.
            String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?, ?, ?);";

            //Preparar Statement com os parâmetros recebidos.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());

            //Executa inserção e armazena o numero de linhas afetadas.
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção bem sucedida! Foi adicionada " + rowsAffected + " linha!");
        } catch (SQLException e){
            System.out.println("Inserção falhou!");
            e.printStackTrace();
        }
    }

    // 3- Delete
    public void delete(int id){
        try(Connection conn = ConnectionFactory.getConnection()){

            //Preparar SQL para deletar uma linha
            String sql = "DELETE FROM aluno WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0){
                throw new SQLException();
            }

            System.out.println("Delete bem sucedido! Foi deletado " + rowsAffected + " linha!");
        } catch (SQLException e){
            System.out.println("Delete falhou!");
            e.printStackTrace();
        }
    }

    // 4- Atualizar
    public void update(Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()){

            //Prepara SQL para atualizar linhas
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado= ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            //Executa atualização e armazena o numero de linhas afetadas.
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0){
                throw new SQLException();
            }

            System.out.println("Atualização bem sucedida! Foi atualizada: " + rowsAffected + " linha!");
        } catch (SQLException e){
            System.out.println("Atualização falhou!");
            e.printStackTrace();
        }
    }

}
