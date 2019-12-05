package dao;

import java.sql.*;
import java.util.HashMap;
import vo.User;
public class UserDao {
    private Connection conn = null;
    private Statement stat = null;
    private ResultSet rs = null;

    //从数据库中获取用户的信息
    public 

    //将用户的注册信息加入数据库
    public int insertUser(User user) throws Exception{
        this.initConnection();
        String sql = "INSERT INTO T_USERS(用户名,密码)" + "VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,user.getUserName());
        ps.setString(2,user.getPassword());
        int i = ps.executeUpdate();
        ps.close();
        this.closeConnection();
        return i;
    }

    public void initConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=User";
        conn = DriverManager.getConnection(url,"sa","sa");
    }

    public void closeResultSet() throws Exception{
        rs.close();
        rs = null;
    }

    public void closeStatment() throws Exception{
        stat.close();
        stat = null;
    }

    public void closeConnection() throws Exception{
        conn.close();
        conn = null;
    }
}
