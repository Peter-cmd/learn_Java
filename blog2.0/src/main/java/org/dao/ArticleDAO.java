package org.dao;

import org.model.Article;
import org.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDAO {
    //添加文章
    public static boolean addArticle(Article article) {
        //创建Conection对象引用
        Connection connection = null;
        //创建PreparedStatement对象引用
        PreparedStatement statement = null;

        try{
            //获取数据库连接
           connection = DBUtil.getConnection();
           //预处理的sql语句
           String sql = "insert into article(title, content, user_id, create_time) " +
                   "values (?, ?, ?, ?)";
           //创建PreparedStatement对象的实例
           statement = connection.prepareStatement(sql);
           statement.setString(1, article.getTitle());
           statement.setString(2, article.getContent());
           statement.setInt(3, article.getUserId());
           statement.setTimestamp(4, new Timestamp(new Date().getTime()));
           int i = statement.executeUpdate();  //执行插入操作
           return i > 0;
        }catch(Exception e){
            throw new RuntimeException("数据库添加文章失败!", e);
        }finally{
            //释放数据库资源
            DBUtil.close(connection, statement);
        }
    }

    public static List<Article> articleList(Integer id){
        List<Article> articles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        connection = DBUtil.getConnection();
        String sql = "select id, title, content, create_time"
                + " from article where user_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                //设置文章信息,并添加进文章列表
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setCreatTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询文章列表jdbc连接失败!", e);
        }finally{
            DBUtil.close(connection, ps, resultSet);
        }

        return articles;
    }

    public static Article queryByArticleId(Integer id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = DBUtil.getConnection();
        String sql = "select id, title, content, create_time"
                + " from article where id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            //设置文章信息,并添加进文章列表
            Article article = new Article();
            while (resultSet.next()){
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setCreatTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()));
            }
            return article;
        } catch (SQLException e) {
            throw new RuntimeException("查询文章详细信息jdbc连接失败!", e);
        }finally{
            DBUtil.close(connection, ps, resultSet);
        }
    }

    public static boolean updateArticle(Article article) {
        //创建Conection对象引用
        Connection connection = null;
        //创建PreparedStatement对象引用
        PreparedStatement statement = null;

        try{
            //获取数据库连接
            connection = DBUtil.getConnection();
            //预处理的sql语句
            String sql = "update article set title = ?, content = ?, create_time = ?" +
                    " where id = ?";
            //创建PreparedStatement对象的实例
            statement = connection.prepareStatement(sql);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getContent());
            statement.setTimestamp(3, new Timestamp(new Date().getTime()));
            statement.setInt(4, article.getId());
            int i = statement.executeUpdate();  //执行插入操作
            return i > 0;
        }catch(Exception e){
            throw new RuntimeException("数据库修改文章jdbc连接失败!", e);
        }finally{
            //释放数据库资源
            DBUtil.close(connection, statement);
        }
    }
}
