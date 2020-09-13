package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample_60 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=123";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("DROP TABLE IF EXISTS tmp;");
            stmt.execute("CREATE TABLE tmp (id INT, name VARCHAR(64))");
            stmt.execute("DROP table tmp");
        }

    }
}
