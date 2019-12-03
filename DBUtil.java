//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static DataSource DATASOURCE = new MysqlDataSource();
    static{
        ((MysqlDataSource)DATASOURCE).setUrl(URL);
        ((MysqlDataSource)DATASOURCE).setUser(USERNAME);
        ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
    }

    private static DataSource DATASOURCE2;
    //无参构造函数
    private DBUtil(){

    }
    public static Connection getConnection1(){
        Connection connection = null;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager .getConnection(URL,USERNAME,PASSWORD);
            } finally {
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        return connection;
    }
    public static Connection getConnection2(){
        Connection connection = null;

        return connection;
    }

    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if (c != null){
                c.close();
            }
            if (s != null){
                s.close();
            }
            if (r != null){
                r.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }

    }

    public static void main(String[] args){
        System.out.println(getConnection1());
    }
}
