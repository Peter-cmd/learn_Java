package org.servlet;

import org.model.Article;
import org.util.JSONUtil;
import org.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req) throws Exception {
        Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);

        if (!ArticleDAO.updateArticle(article)){
            throw new RuntimeException("文章信息修改失败!");
        }
        return article;
    }
}
