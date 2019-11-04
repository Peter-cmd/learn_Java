
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class sqlserver {
 public static void main(String[] args) {
Connection conn;
 Statement stmt;
 ResultSet rs;
 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=student;";
 String sql = "select * from student";
 try {
 // 连接数据库
 conn = DriverManager.getConnection(url, "sa", "sa");
 // 建立Statement对象
 stmt = conn.createStatement();
 // 执行数据库查询语句
 rs = stmt.executeQuery(sql);
while (rs.next()) {
    String id = rs.getString("学号");
    String name = rs.getString("姓名");
//                int age = rs.getInt("Sage");
System.out.println("Sno:" + id + "\tSame:" + name );
}
if (rs != null) {
 rs.close();
 rs = null;
 if (stmt != null) {
stmt.close();
stmt = null;
 }
 if (conn != null) {
     conn.close();
 }
conn = null;
}
} catch (SQLException e) {
e.printStackTrace();
System.out.println("数据库连接失败");
}
 }
}