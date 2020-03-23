package org.servlet;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NestedParticle;
import org.dao.ArticleDAO;
import org.model.Article;
import org.model.Result;
import org.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req) throws Exception {
        Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);
        article.setUserId(1);
        System.out.println("请求的数据" + article);
        //把文章信息保存到数据库
        if (!ArticleDAO.addArticle(article)){
            throw new RuntimeException("文章添加失败!");
        }
        return article;
    }
}
