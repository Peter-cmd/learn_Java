package org.servlet;

import org.dao.ArticleDAO;
import org.model.Article;
import org.model.Result;
import org.util.JSONUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req) throws Exception {
        Integer id = Integer.parseInt(req.getParameter("id"));
        List<Article> articles = ArticleDAO.articleList(id);
        return articles;
    }
}

