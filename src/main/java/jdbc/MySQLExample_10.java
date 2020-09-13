package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLExample_10 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=123";

    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        Connection connect = driver.connect(JDBC_URL, new Properties());

        try {
            //use conn
        }finally {
            connect.close();
        }
    }

}
