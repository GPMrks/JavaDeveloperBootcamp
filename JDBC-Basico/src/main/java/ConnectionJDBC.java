import JDBC.Aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {

//        String urlconnection = "jdbc:mysql://localhost/digital_innovation_one";
//
//        try (Connection conn = DriverManager.getConnection(urlconnection,"root", "password")){
//            System.out.println("Sucesso!");
//        } catch (Exception e){
//            System.out.println("Falha!");
//        }

        String driver = "mysql";
        String dataBaseAdress = "localhost";
        String dataBaseName = "digital_innovation_one";
        String user = "root";
        String password = "password";

        StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAdress).append("/")
                .append(dataBaseName);

        String urlConnection = sb.toString();

        try (Connection conn = DriverManager.getConnection(urlConnection, user, password)){
            System.out.println("Sucesso!");
        } catch (Exception e) {
            System.out.println("Falha!");
        }

        //POSTGRES
//        String driver = "postgresql";
//        String dataBaseAdress = "localhost:5433";
//        String dataBaseName = "financas";
//        String user = "postgres";
//        String password = "Gui10263";
//
//        StringBuilder sb = new StringBuilder("jdbc:")
//                .append(driver).append("://")
//                .append(dataBaseAdress).append("/")
//                .append(dataBaseName);
//
//        String urlConnection = sb.toString();
//
//        System.out.println(urlConnection);
//
//        try (Connection conn = DriverManager.getConnection(urlConnection, user, password)){
//            System.out.println("Sucesso!");
//        } catch (Exception e){
//            System.out.println("Falha!");
//        }
    }
}
