import java.sql.*;

public class MySQLConnector 
{

    public static Connection conectar() {

        String mysqlHost = "127.0.0.1";
        String mysqlDb = "db_senac";
        String mysqlUser = "root";
        String mysqlPassword = "131313";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + 
        mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(mysqlUrl); 
            // System.out.println("Conexão estabelecida!");
        } catch (Exception e) {
            System.err.println("Ops! Deu ruim pra cacete ai cumpadi!" +e);
        }
        return conn;
    }
}
