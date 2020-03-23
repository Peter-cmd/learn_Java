package org.servlet;

import org.dao.ArticleDAO;
import org.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet{

    @Override
    public Object process(HttpServletRequest req) throws Exception {

        //获取文章id
        Integer id = Integer.parseInt(req.getParameter("id"));
        Article article = ArticleDAO.queryByArticleId(id);
        return article;
    }
}
