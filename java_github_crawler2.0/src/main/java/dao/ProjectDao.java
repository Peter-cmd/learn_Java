package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ProjectDao {

    public void save(Project project) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "Insert into project_table values(?,?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getUrl());
            statement.setString(3, project.getDescription());
            statement.setInt(4, project.getStartCount());
            statement.setInt(5, project.getForkCount());
            statement.setInt(6, project.getOpenIssueCount());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            statement.setString(7, simpleDateFormat.format(System.currentTimeMillis()));
            int i = statement.executeUpdate();
            if (i < 1) {
                System.out.println("数据插入失败!");
            } else {
                System.out.println("数据插入成功!");
            }
            DBUtil.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
