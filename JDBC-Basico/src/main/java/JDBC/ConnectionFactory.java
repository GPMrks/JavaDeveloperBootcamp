package JDBC;

import com.mysql.cj.exceptions.UnsupportedConnectionStringException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    //Construtor declarado como privado. Evitando assim criar instâncias da fábrica.
    private ConnectionFactory() {
        throw new UnsupportedConnectionStringException();
    }

    public static Connection getConnection() {

        // 1- Declarar objeto conexão (irá receber uma conexão após executar os passos abaixo)
        Connection connection = null;

        // 2- Carregar arquivo de propriedade para pegar parâmetros necessários para se comunicar com o banco de dados.
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("Connection.properties")) {

            // 3- Definir parâmentros para se conectar ao banco de dados MySQL.
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // 4- Construção da String de conexão.
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionURL = sb.toString(); //sb.toString() == "jdbc:mysql://localhost/digital_innovation_one"

            // 5- Criar conexão usando o DriverManager, passando como parâmetros a string de conexão, usuário e senha do usuário.
            try {
                connection = DriverManager.getConnection(connectionURL, user, password);
            } catch (SQLException e) {
                System.out.println("Falha ao tentar criar conexão!!!");
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("Falha ao tentar carregar arquivo de propriedades!!!");
            e.printStackTrace();
        }

        return connection;
    }
}