package jdbc;

import java.sql.*;

public class MySQLExample_70 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=123&serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL);
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS tmp;");
            stmt.execute("CREATE TABLE tmp (id INT , name VARCHAR(64));");
            stmt.execute("INSERT INTO tmp (id, name) VALUES (2, 'Tom');");
            conn.commit();
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM tmp;");

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "|" + name + "\n");
            }
            stmt.execute("DROP TABLE tmp;");
        } catch (Exception e) {
            if (conn != null){
                conn.rollback();
            }
        }finally {
            conn.close();
        }
    }
}
