package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static Connection connection;
    private static final String jdbc = "jdbc:mysql://localhost:3306/%s";

    public static void createConnection(String user, String password, String dbName) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        String formattedJdbc = String.format(jdbc, dbName);

        connection = DriverManager.getConnection(formattedJdbc, props);
    }

    public static Connection getConnection() {
        return connection;
    }
}
