import Classes.Aluno;
import Classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionPart2 {

    public static void main(String[] args) {

        // OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
        // Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.

        // O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1- Criar instâncias para serem adicionadas no banco de dados.
        Estado estadoParaAdicionar = new Estado("Minas Gerais", "MG");
        Aluno alunoParaAdicionar = new Aluno("Guilherme", 27, estadoParaAdicionar);
        Aluno alunoParaAdicionar2 = new Aluno("Caroline", 28, estadoParaAdicionar);

        // 2.2- Iniciar uma transação para adicionar as instâncias no banco de dados.
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);
        entityManager.persist(alunoParaAdicionar2);

        entityManager.getTransaction().commit();

        // 3- Resgatar instâncias no banco de dados.
        Estado estadoEncontrado = entityManager.find(Estado.class, 1);
        Aluno alunoEncontrado = entityManager.find(Aluno.class, 2);

        System.out.println(estadoEncontrado);
        System.out.println(alunoEncontrado);

        // 4- Alterar uma entidade
        entityManager.getTransaction().begin();

          //Alterando enquanto busca
//        entityManager.find(Aluno.class, 2).setNome("Marcão");
//        entityManager.find(Aluno.class, 2).setIdade(18);

        //Alterando utilizando a variavel utilizada para buscar.
        alunoEncontrado.setNome("José");
        alunoEncontrado.setIdade(19);

        entityManager.getTransaction().commit();

        // 5- Removendo uma entidade
        entityManager.getTransaction().begin();

        //Removendo sem utilizar variavel
        entityManager.remove(entityManager.find(Aluno.class, 2));

        //Removendo utilizando variavel previamente utilizada para busca
//        entityManager.remove(alunoEncontrado);

        entityManager.getTransaction().commit();

        // 6- Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }
}
